public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int level = n/2;
        int x = 1;
        for(int r = 0; r < level; r++){
            for(int i = r;i < n-r-1;i++){
                matrix[r][i] = x;
                x++;
            }
            for(int i = r; i < n-r-1;i++){
                matrix[i][n-1-r] = x;
                x++;
            }
            for(int i = n-1-r; i > r;i--){
                matrix[n-1-r][i] = x;
                x++;
            }
            for(int i = n-1-r;i > r;i--){
                matrix[i][r] = x;
                x++;
            }
        }
        if(n%2 == 1){
            matrix[level][level] = x;
        }
        return matrix;
    }
}
//这道题跟I一样一样的 更加简单些！！！！