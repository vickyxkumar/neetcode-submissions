class Solution {
    public boolean dfs(String s, int idx, int n1, int [][] memo){

        if(n1 < 0){
            return false;
        }

        if(idx == s.length()){
            return n1 == 0 ? true : false;
        }

        if(memo[idx][n1] != -1) return memo[idx][n1] == 1 ? true : false;

        if(s.charAt(idx) == '*' && (dfs(s, idx+1, n1+1, memo) || dfs(s, idx+1, n1-1, memo) || dfs(s, idx+1, n1, memo))){
            memo[idx][n1] = 1;
            return true;
        }else if (s.charAt(idx) == '(' && dfs(s, idx + 1, n1+1, memo)){
            memo[idx][n1] = 1;
            return true;
        }else if (s.charAt(idx) == ')' && dfs(s, idx + 1, n1-1, memo)){
            memo[idx][n1] = 1;
            return true;
        }

        memo[idx][n1] = 0;

        return false;
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        int [][] memo = new int[n][n];
        for(int i = 0; i< n; i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(s, 0, 0, memo);
    }
}
