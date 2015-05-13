public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int [][] res = new int[m][n];
        if(dungeon[m-1][n-1] < 0){
            res[m-1][n-1] = 1 - dungeon[m-1][n-1];
        }else{
            res[m-1][n-1] = 1;
        }
        for(int i = m - 2; i >=0; i--){
            res[i][n-1] = Math.max(1, res[i+1][n-1] - dungeon[i][n-1]);
        }
        for(int j = n - 2; j >=0; j--){
            res[m-1][j] = Math.max(1,res[m-1][j+1] - dungeon[m-1][j]);
        }
        
        for(int i = m-2; i>=0; i--){
            for(int j= n-2; j>=0; j--){
                res[i][j] = Math.max(1, Math.min(res[i+1][j],res[i][j+1]) - dungeon[i][j]);
            }
        }
        return res[0][0];
        
    }
}