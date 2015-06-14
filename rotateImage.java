/*
这个和spiral matrix很像，都是分层，
直接按照层数 每层里面转换就可以。
就是要注意，单层里面rotate的时候，要寸tmp一个，剩下的几个坐标别弄错，顺序也不要弄错，画我自创的坐标图就ok。
时间复杂度是O(矩阵的大小)
*/
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length) return;
        int level = matrix.length/2;
        int n = matrix.length;
        for(int r = 0; r < level; r++){
            for(int i = r; i < n-1-r; i++){
                int tmp = matrix[n-1-i][r];
                matrix[n-1-i][r] = matrix[n-1-r][n-1-i];
                matrix[n-1-r][n-1-i] = matrix[i][n-1-r];
                matrix[i][n-1-r] = matrix[r][i];
                matrix[r][i] = tmp;
            }
        }
    }
}