class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }

        int median = (m + n + 1) / 2;

        int i = 0, j = m;

        while (i <= j) {
            int line1 = (j-i) / 2 + i;
            int line2 = median - line1;

            int left1 = line1 == 0 ? Integer.MIN_VALUE : nums1[line1 - 1];
            int right1 = line1 == m ? Integer.MAX_VALUE : nums1[line1];

            int left2 = line2 == 0 ? Integer.MIN_VALUE : nums2[line2 - 1];
            int right2 = line2 == n ? Integer.MAX_VALUE : nums2[line2];

            if (right2 >= left1 && right1 >= left2) {

                int maxLeft = Math.max(left1, left2);
                // you find your answer
                if (((m+n) % 2) == 1) {
                    // this is even
                    return maxLeft;
                }

                int minRight = Math.min(right1, right2);

                return ( (double) minRight + maxLeft)/2;
                
            } else if (right1 < left2) {
                i = line1 + 1;
            } else if (right2 < left1) {
                j = line1 - 1;
            }
        }

        return 0.0;
    }
}
