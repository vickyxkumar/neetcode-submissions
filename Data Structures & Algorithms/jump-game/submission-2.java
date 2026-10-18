class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastTrueIdx = n-1;
        for(int i = n-2; i >= 0; i--){
            int maxJump = i + nums[i];
            if(lastTrueIdx <= maxJump){
                lastTrueIdx = i;
            }
        }

        return lastTrueIdx == 0;
    }
}
