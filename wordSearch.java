//这个题目的重点就是DFS，还有使用一个visited的boolean数组来记录是不是走过。还有不同的DFS执行完毕要把visited设置回false
//以board中每一点作为起始点来进行DFS。
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0){
            return true;
        }
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(search(board,word,0,i,j,visited)){
                    return true;//开始简写成为return search(board,word,0,i,j,visited) 发现行不通。。因为逻辑不对
                }
            }
        }
        return false;
    }
    private boolean search(char[][] board, String word, int index, int i, int j, boolean[][] visited){
        if(index == word.length()){
            return true;
        }
        
        if(i < 0 || j < 0 || i > board.length -1 || j > board[0].length -1 || visited[i][j] || 
        board[i][j] != word.charAt(index)){
            return false;
        }
        visited[i][j] = true;
        boolean res = search(board,word,index+1,i-1,j,visited)||
                      search(board,word,index+1,i+1,j,visited)||
                      search(board,word,index+1,i,j-1,visited)||
                      search(board,word,index+1,i,j+1,visited);
        visited[i][j] = false;
        return res;
    }
}