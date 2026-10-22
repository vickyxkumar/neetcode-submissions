class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int [] nge =  new int[n];
        nge[n-1] = -1;
        int lastHeight = height[n-1];
        for(int i = n-2; i >= 0; i--){
            if(lastHeight < height[i]){
                nge[i] = -1;
                lastHeight = height[i];
            }else if(lastHeight > height[i]){
                nge[i] = lastHeight;
            }else{
                nge[i] = lastHeight;
                lastHeight = height[i];
            }
        }

        // System.out.println(Arrays.toString(nge));


        int prev = height[0];
        int rainArea = 0;
        for(int i = 1; i < n; i++){
            if(prev < height[i]){
                prev = height[i];
            }

            if(prev >= height[i] && nge[i] != -1){
                rainArea += Math.abs(Math.min(prev, nge[i]) - height[i]);
            }
        }

        return rainArea;
    }
}
