/*
重点在于HashSet的使用 每行 每列 每个小块
小块的循环怎么写？使用一个k从0~8 行号是k/3*3 ~ k/3*3+3 列号 k%3*3 ~ k%3*3+3
Time: O(3*n^2), n=9
*/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < 9;i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
            set.clear();
        }
        for(int j = 0; j < 9; j++){
            for(int i = 0; i < 9; i++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
            set.clear();
        }
        for(int block = 0; block < 9; block++){
            for(int i = block/3*3; i < block/3*3 + 3; i++){
                for(int j = block%3 *3; j < block%3 *3+3;j++){
                    if(board[i][j] == '.') continue;
                    if(set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        return true;
    }
}