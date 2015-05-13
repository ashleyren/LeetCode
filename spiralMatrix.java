public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int level = Math.min(m,n)/2;
        for(int r = 0; r < level; r++){//留出最后一个level。。。。。做最后的判断
            for(int i = r;i < n-r-1;i++){
                res.add(matrix[r][i]);
            }
            for(int i = r; i < m-r-1;i++){
                res.add(matrix[i][n-1-r]);
            }
            for(int i = n-1-r; i > r;i--){
                res.add(matrix[m-1-r][i]);
            }
            for(int i = m-1-r;i > r;i--){
                res.add(matrix[i][r]);
            }
        }
        if(Math.min(m,n) % 2 == 1){
            if(m < n){
                for(int i = level;i <n-level;i++){
                res.add(matrix[level][i]);
                }
            }else{
                for(int i = level; i < m-level;i++){
                res.add(matrix[i][level]);
                }
            }
        }
        return res;
    }
}