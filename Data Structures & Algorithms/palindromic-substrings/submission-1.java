class Solution {
    // the quickest solution that I can think is take using nested for loop. 
    // considered a substring from index i to j and then check if is palindrome or not
    public int countSubstrings(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];

        int count = 0;

        for(int len = 1; len <= n; len++){
            for(int j = 0; j + len -1 < n; j++){
                int m = j + len - 1;
                dp[j][m] = (s.charAt(j) == s.charAt(m)) && (len < 3 || dp[j+1][m-1]);
                if(dp[j][m]) count++;
            }
        }

        return count;

    }
}
