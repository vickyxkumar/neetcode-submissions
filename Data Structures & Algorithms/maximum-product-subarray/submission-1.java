class Solution {
    // the first solution that is quick I can think of is use  nested loop and calculate all the possible product of subarray and find the maximum product.
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE, prefixProduct = 1, sufixProduct = 1;
        int n = nums.length;
        for(int i = 0; i< nums.length; i++){
            prefixProduct *= nums[i];
            sufixProduct *= nums[n-1-i];
            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, sufixProduct));
            if(prefixProduct == 0) prefixProduct = 1;
            if(sufixProduct == 0) sufixProduct = 1;
        }

        return maxProduct;
    }
}
