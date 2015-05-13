public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length; 
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != '1') continue;
                dfs(grid,i,j);
                res++;
            }
        }
        return res;    
    }
    private void dfs(char[][] grid, int i, int j){
        if(i<0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if(grid[i][j] == '1'){//不要忘记这一步的判断啊。。。。。不然就不通过
            grid[i][j] = '2';
            dfs(grid,i-1,j);
            dfs(grid,i+1,j);
            dfs(grid,i,j+1);
            dfs(grid,i,j-1);
        }
    }
}