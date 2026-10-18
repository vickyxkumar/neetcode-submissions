class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean [] history = new boolean[n];
        history[n-1] = true;
        for(int i = n-2; i >= 0; i--){
            for(int j = 1; j<= nums[i]; j++){
                int jump  = i + j;
                if(history[jump]){
                    history[i] = true;
                    break;
                }
            }
        }

        return history[0];
    }
}
