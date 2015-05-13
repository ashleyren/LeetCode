public class Solution {
    public int totalNQueens(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        helper(n,0,new int[n],res);
        return res.get(0);
    }
    private void helper(int n, int row, int[] board, ArrayList<Integer> res){
        if(row == n){
            res.set(0, res.get(0)+1);
            return;
        }
        for(int i = 0; i< n; i++){
            board[row] = i;
            if(isValid(board,row)){
                helper(n,row+1,board,res);
            }
        }
    }
    private boolean isValid(int[] board, int row){
        for(int i = 0; i < row; i++){
            if(board[row] == board[i] ||
            Math.abs(board[row]-board[i]) == Math.abs(row-i)) return false;
        }
        return true;
    }
}