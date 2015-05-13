public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int tmp = 1;
        int res[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++){
            if(obstacleGrid[i][0] == 1){
                tmp = 0;
            }
            res[i][0] = tmp;
        }
        tmp = 1;
        for(int j = 0; j < obstacleGrid[0].length; j++){
            if(obstacleGrid[0][j] == 1){
                tmp = 0;
            }
            res[0][j] = tmp;
        }
        
        for(int i = 1; i < obstacleGrid.length; i++){
            for(int j = 1; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j] == 1){
                    res[i][j] = 0;
                }else{
                    res[i][j] = res[i-1][j] + res[i][j-1];
                }
            }
        }
        return res[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}