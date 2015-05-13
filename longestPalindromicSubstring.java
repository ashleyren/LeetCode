public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        if(s == null || s.length() == 0) return res;
        int maxlen = 0;
        for(int i = 0; i < 2*s.length()-1; i++){
            int left = i/2;
            int right = left;
            if(i%2 == 1) right++;
            String cur = helper(s,left,right);
            if(maxlen < cur.length()){
                maxlen = cur.length();
                res = cur;
            }
        }
        return res;
    }
    private String helper(String s, int left, int right){
        while(left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}