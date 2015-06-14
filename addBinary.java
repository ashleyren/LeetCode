/*
从最后一位开始, 开始加, 先把两个都有的位加了,然后剩下一个长一点的string的位加了,最后判断carry是不是为0,不是0要加上去.
最后把结果翻转,因为是从低位应该放在后面.返回成String
时间复杂度是O(max(m,n))，m和n分别是两个字符串的长度，空间复杂度是结果的长度O(max(m,n))
*/
public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0){
            int cur = (int) (a.charAt(i)-'0' + b.charAt(j)-'0') + carry;
            carry = cur/2;
            cur = cur % 2;
            sb.append(cur);
            i--;
            j--;
        }
        while(i>=0){
            int cur = (int) (a.charAt(i)-'0') + carry;
            carry = cur/2;
            cur = cur % 2;
            sb.append(cur);
            i--;
        }
        while(j>=0){
             int cur = (int) (b.charAt(j)-'0') + carry;
            carry = cur/2;
            cur = cur % 2;
            sb.append(cur);
            j--;
        }
        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}