class Solution {
    public int dfs(int n, int idx, int[] dp){
        if(idx > n) return 0;
        
        if(idx == n) return 1;
        
        if(dp[idx] != 0) return dp[idx];

        int oneStep = dfs(n, idx + 1, dp);
        int twoStep = dfs(n, idx + 2, dp);

        return dp[idx] = oneStep + twoStep;
    }
    public int climbStairs(int n) {
        int [] dp = new int[n+1];
        dp[n] = 0;
        return dfs(n, 0, dp);
    }
}
