class Solution {
    // the idea here is make the partation and check if the first substring is valid or notj-             m
    public int dfs(String s, int idx, int[] dp) {
        if (idx == s.length())
            return 1;

        if (s.charAt(idx) == '0')
            return 0;

        if(dp[idx] != -1) return dp[idx];

        int cnt = 0;
        for (int i = idx; i < s.length(); i++) {
            String val = s.substring(idx, i+1);
            if (Integer.parseInt(val) > 26) {
                break;
            }
            cnt += dfs(s, i + 1, dp);
        }

        return dp[idx] = cnt;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int[n];
            Arrays.fill(dp, -1);

        return dfs(s, 0, dp);
    }
}
