public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || 
        matrix.length != matrix[0].length || 
        matrix.length == 0 || 
        matrix[0].length == 0) return;
        int n = matrix.length;
        int layerNum = n/2;
        for(int i = 0;i< layerNum;i++){
            for(int j = i; j < n-1-i ;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
}