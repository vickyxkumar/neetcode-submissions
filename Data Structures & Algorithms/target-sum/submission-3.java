class Solution {
    public int dfs(int[] nums, int target, int idx, int sum, int dp[][]){
        if(idx == nums.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[idx][sum+20001] != -1) return dp[idx][sum+20001];

        int left = dfs(nums, target, idx + 1, sum + nums[idx], dp);
        int right = dfs(nums, target, idx + 1, sum - nums[idx], dp);

        dp[idx][sum+20001] = left + right;
        return dp[idx][sum+20001];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n][40001];
        for(int i = 0; i< n; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(nums, target, 0, 0, dp);
    }
}
