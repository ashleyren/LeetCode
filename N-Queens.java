public class Solution {
    public List<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        helper(n,0,new int[n],res);
        return res;
    }
    private void helper(int n, int rowStart, int[] board, ArrayList<String[]> res){
        if(rowStart == n){
            String[] item = new String[n];
            for(int i = 0; i< n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<n;j++){
                    if(board[i] == j){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                item[i] = sb.toString();
            }
            res.add(item);
            return;
        }
        for(int i = 0; i< n; i++){
            board[rowStart] = i;
            if(isValid(board,rowStart)){
                helper(n,rowStart+1,board,res);
            }
        }
        
    }
    private boolean isValid(int[] board,int row){
        for(int i = 0; i< row;i++){
            if(board[i] == board[row] || 
            Math.abs(board[i] - board[row]) == Math.abs(i-row)) return false;
        }
        return true;
    }
}