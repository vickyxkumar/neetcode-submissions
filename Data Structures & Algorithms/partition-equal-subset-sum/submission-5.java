class Solution { 

    public boolean dfs(int [] nums, int target, int idx, int [][] dp){
        if(target == 0) return true;

        if(target < 0) return false;

        if(idx >= nums.length) return false;

        if(dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean take = dfs(nums, target - nums[idx], idx + 1, dp);
        boolean notTake = dfs(nums, target, idx+1, dp);

        dp[idx][target] = (take || notTake) ? 1 : 0;

        return dp[idx][target] == 1;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums) sum += ele;
        if(sum % 2 != 0) return false;

        int target = sum/2;

        int dp[][]  = new int [nums.length][target+1];
        for(int i = 0; i<nums.length; i++) Arrays.fill(dp[i], -1);
        return dfs(nums, target, 0, dp);

    }
}
