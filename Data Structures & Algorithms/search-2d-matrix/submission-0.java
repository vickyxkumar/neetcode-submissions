class Solution {
    // Assuming each of the list is side by side you can perform the binary search
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int low = 0, high = row * col-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int currRow = mid/col, currCol = mid%col;
            int midVal = matrix[currRow][currCol];
            if(midVal < target){
                low = mid + 1;
            }else if(midVal > target){
                high = mid - 1;
            }else{
                return true;
            }
        }

        return false;
    }
}
