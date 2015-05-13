public class Solution {
    public int numDistinct(String S, String T) {
        int[][] res = new int[T.length()+1][S.length()+1];
        //T is null
        for(int i = 0; i < S.length() + 1 ; i++){
            res[0][i] = 1;
        }
        //S is null
        for(int j = 1; j < T.length() + 1; j++){
            res[j][0] = 0;
        }
        for(int i = 1; i < S.length() + 1 ;i++){
            for(int j = 1; j < T.length() + 1;j++){
                res[j][i] = res[j][i-1];
                if(S.charAt(i-1) == T.charAt(j-1)){//这里特别要注意的是 res[][]的下标要比S和T比较位的下标大1，因为res开头是S和T为null的情况
                    res[j][i] += res[j-1][i-1]; 
                }
            }
        }
        return res[T.length()][S.length()];
    }
}