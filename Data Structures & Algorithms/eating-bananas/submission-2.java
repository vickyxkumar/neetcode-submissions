class Solution {

    public boolean isPossible(int [] piles, int k, int targetHour){
        int totalHour = 0;
        for(int i = 0; i< piles.length; i++){
            if(piles[i] < k){
                totalHour += 1;
            }else{
                totalHour += (int) Math.ceil((double) piles[i]/k);
            }

            if(totalHour > targetHour) return false;
        }

        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int high = Integer.MIN_VALUE;
        int low = 0;

        for(int ele : piles){
            high = Math.max(high, ele);
        }

        while(low <= high){
            int k = (high - low)/2 + low;
            if(isPossible(piles, k, h)){
                high = k-1;
            }else{
                low = k+1;
            }
        }

        return low;
    }
}
