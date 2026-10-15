class Solution {

    // if I follow the buttom to up approach
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[n-1];
        }
        int [] dp = new int [n+1];
        dp[n] = 0;
        dp[n-1] = nums[n-1];
        dp[n-2] = nums[n-2];

        for(int i = n-3; i >=0; i--){
            dp[i] = Math.max(dp[i+2], dp[i+3]) + nums[i];
        }

        return Math.max(dp[0], dp[1]);
    }
}
