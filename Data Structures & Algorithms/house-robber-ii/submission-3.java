class Solution {
    public int dfs(int[] nums, int idx, int range, int dp[]) {
        if (idx >= range)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int take = dfs(nums, idx + 2, range, dp) + nums[idx];
        int skip = dfs(nums, idx + 1, range, dp);

        return dp[idx] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        // handle the case where only two houses are there.
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[1], nums[0]);
        // i know that I have skip the adjacent but not sure that if I am skipping the next element
        // to adjacent. Pretty I can choose or I skip.

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n - 1] = nums[n - 1];
        int case1 = dfs(nums, 0, n-1 ,dp);
        Arrays.fill(dp, -1);
        int case2 = dfs(nums, 1, n , dp);

        return Math.max(case1, case2);
    }
}
