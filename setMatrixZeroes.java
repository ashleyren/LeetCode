/*
前两种简单的方法 一个是存单独的0矩阵 另外一个是存行列boolean[]数组
优化的方法，使用第一行和第一列来存是否变0: 那么要行列两个flag，首先看他们是不是最后归0
然后出去第一行第一列开始逐个如果为0就把第一行第一列的值变为0
然后遍历第二遍如果行列有0就变0
最后两个flag判断完毕就ok了
time O(m*n) space O(1)
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null ||matrix.length == 0 || matrix[0].length == 0) return;
        boolean rowFlag = false;
        boolean colFlag = false;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                colFlag = true;
                break;
            }
        }
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                rowFlag = true;
                break;
            }
        }
        for(int i=1; i < matrix.length;i++){
            for(int j = 1; j< matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < matrix.length; i++){
                for(int j = 1; j< matrix[0].length; j++){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }

        if(rowFlag){
            for(int i = 0; i < matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }
        
        if(colFlag){
            for(int i = 0; i < matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
    }
}