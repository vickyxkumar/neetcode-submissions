class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[m-1][n-1] = 1;
        for(int sum = m - 2 + n -1; sum >= 0; sum--){
            int low = Math.max(0, sum - (n -1));
            int high = Math.min(m-1, sum);
            for(int i = low; i<= high; i++){
                int j = sum - i;
                dp[i][j] = 0;
                if(i+1 < m) dp[i][j] += dp[i+1][j];
                if(j+1 < n) dp[i][j] += dp[i][j+1];
            }
        }

        return dp[0][0];
    }
}
