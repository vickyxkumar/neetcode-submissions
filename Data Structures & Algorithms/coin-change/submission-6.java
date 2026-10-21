class Solution {
    public int dfs(int [] coins, int amount, int [] dp){

        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return Integer.MAX_VALUE-1;
        }

        if(dp[amount] != -1) return dp[amount];

        int minCount = Integer.MAX_VALUE-1;

        for(int coin : coins){
            int finalCount = dfs(coins, amount - coin, dp) + 1;
            minCount = Math.min(minCount, finalCount);
        }

        return dp[amount] = minCount;
    }
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp, -1);
        int count = dfs(coins, amount, dp);
        return count == Integer.MAX_VALUE-1 ? -1: count;
    }
}
