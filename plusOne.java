/*
判断进位加1,如果有carry就继续进行,carry为0了则立即返回结果. 
如果到最高位还有carry就要新建一个数组,最高位为1,其他位是0,因为只进了1位说明其他原来是99999...
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        int carry = 1;
        for(int i = digits.length - 1; i>=0; i--){
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
            if(carry == 0){
                return digits;
            }
        }
        if(carry == 1){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}