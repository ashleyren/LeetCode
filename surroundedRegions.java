public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length <=1 || board[0].length <= 1) return;
        
        for(int i = 0; i < board.length; i++){
            fill(board,i,0);
            fill(board,i,board[0].length - 1);
        }
        for(int i = 0; i< board[0].length; i++){
            fill(board,0,i);
            fill(board,board.length - 1,i);
        }
        for(int i = 0; i < board.length; i++){
            for(int j =0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    private void fill(char[][] board, int i, int j){
        if(board[i][j] != 'O'){
            return;
        } else{
            board[i][j] = '#';
        }
        LinkedList<Integer> q = new LinkedList<Integer>();
        int code = encode(board,i,j);
        q.add(code);
        while(!q.isEmpty()){
            code = q.poll();
            int row = code / board[0].length;
            int col = code % board[0].length;
            
            if(row >=1 && board[row-1][col] == 'O'){
                board[row-1][col] = '#';
                q.add(encode(board,row-1,col));
            }
            
            if(row <= board.length -2 && board[row+1][col] == 'O'){
                board[row+1][col] = '#';
                q.add(encode(board,row+1,col));
            }
            
            if(col >=1 && board[row][col-1] == 'O'){
                board[row][col-1] = '#';
                q.add(encode(board,row,col-1));
            }
            
            if(col <= board[0].length -2 && board[row][col+1] == 'O'){
                board[row][col+1] = '#';
                q.add(encode(board,row,col+1));
            }
        }
    }
    
    private int encode(char[][] board, int i, int j){
        return i * board[0].length + j;
    }
}