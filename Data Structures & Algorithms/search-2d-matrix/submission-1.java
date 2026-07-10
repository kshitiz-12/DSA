class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row*col-1;

        while(left<=right){
            int mid = left+(right-left)/2;

            int rows = mid/col;
            int cols = mid%col;

            if(matrix[rows][cols]==target){
                return true;
            }
            else if(matrix[rows][cols]<target){
                left ++;
            }
            else{
                right--;
            }
        }
        return false;
    }
}
