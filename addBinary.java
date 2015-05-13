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