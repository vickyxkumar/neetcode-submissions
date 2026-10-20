class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int dp[] = new int[n+1];
        for(int i = 1; i<= m; i++){
            int temp[] = new int[n+1];
            for(int j = 1; j <= n; j++){
                temp[j] = text1.charAt(i-1) == text2.charAt(j-1) ? dp[j-1] + 1 : Math.max(dp[j], temp[j-1]);
            }
            dp = temp;
        }

        return dp[n];
    }
}
