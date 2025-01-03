class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i =0;
        int j = matrix.length*matrix[0].length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(matrix[mid/matrix[0].length][mid%matrix[0].length] == target){
                return true;
            }else{
                if(matrix[mid/matrix[0].length][mid%matrix[0].length] < target){
                    i = mid+1;
                }else{
                    j = mid-1;
                }
            }
        }
        return false;
    }
}