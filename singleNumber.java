/*
异或起来！凡是相等的数字在位运算异或的时候 就变成了0，代表抵消掉了，全部异或一遍就剩下那个落单的数
*/
public class Solution {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0) return 0;
        int res = A[0];
        for(int i = 1; i < A.length; i++){
            res = res ^ A[i]; //按位异或 相同的就变成0了！
        }
        return res;
    }
}