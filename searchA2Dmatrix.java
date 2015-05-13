public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0; 
        int r = m - 1;
        int row = -1;
        while(l <= r){
            int mid = (l+r)/2;
            if(matrix[mid][0] <= target && target <= matrix[mid][n-1]){
                row = mid;
                break;
            }
            if(target < matrix[mid][0]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        if(row == -1) return false;
        l = 0;
        r = n - 1;
        while(l <= r){
            int mid = (l+r)/2;
            if(matrix[row][mid] == target){
                return true;
            }
            if(target < matrix[row][mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}