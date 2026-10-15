class Solution {

    public int dfs(int [] nums, int idx, int dp[]){
        if(idx >= nums.length) return 0;

        if(dp[idx] != 0) return dp[idx];

        int skip1 = dfs(nums, idx + 2, dp);
        int skip2 = dfs(nums, idx + 3, dp);

        return dp[idx] = Math.max(skip1, skip2) + nums[idx];
    }
    
    public int rob(int[] nums) {

        // handle the case where only two houses are there.
        // if(nums.length == 1) return nums[0];
        // if(nums.length == 2) return Math.max(nums[1], nums[0]);
        // i know that I have skip the adjacent but not sure that if I am skipping the next element to adjacent. Pretty I can choose or I skip.

        int n = nums.length;
        int []dp = new int[n];
        dp[n-1] = nums[n-1];

        return Math.max(dfs(nums, 0, dp), dfs(nums, 1, dp));    
    }
}
