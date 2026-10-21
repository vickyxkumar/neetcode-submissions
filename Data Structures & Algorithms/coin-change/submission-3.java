class Solution {
    public boolean dfs(int [] coins, int targetAmount, int idx, int minCount[], int count){

        if(targetAmount == 0){
            return true;
        }


        while(idx  >= 0 && targetAmount < coins[idx]){
            idx--;
        }

        if(idx < 0) return false;

        int times = targetAmount / coins[idx];
        for(int time = times; time >= 0; time--){
            boolean possible = dfs(coins, targetAmount - coins[idx]*time, idx - 1, minCount, count + time);
            if(possible){
                count += time;
                minCount[0] = Math.min(minCount[0], count);
            }
        }

        return false;
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int [] minCount = new int[1];
        minCount[0] = Integer.MAX_VALUE;
        Arrays.sort(coins);
        dfs(coins, amount, coins.length-1, minCount, 0);

        return minCount[0] == Integer.MAX_VALUE ? -1 : minCount[0];
    }
}
