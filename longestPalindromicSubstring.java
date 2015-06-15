/*
这个呢就是找出各个center 判断该中心的最大回文子串.
2*n-1(字符作为中心有n个，间隙有n-1个）。对于每个中心往两边扫描的复杂度为O(n),所以时间复杂度为O((2*n-1)*n)=O(n^2),
这个题目中假设最长回文子串只有一个，实际面试中一般不做这种假设，
如果要返回所有最长回文串，只需要稍做变化就可以，维护一个集合，如果等于当前最大的，即加入集合，否则，如果更长，则清空集合，加入当前这个。
*/
//更好的解法.Time O(n^2), Space O(1)
public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        String longest = s.substring(0,1);
        for(int i = 0; i < s.length(); i++){
            String tmp = helper(s,i,i);
            if(tmp.length() > longest.length()){
                longest = tmp;
            }
            tmp = helper(s,i,i+1);
            if(tmp.length() > longest.length()){
                longest = tmp;
            }
        }
        return longest;
    }
    private String helper(String s, int left, int right){
        if(s == null || s.length() == 0) return s;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}
//动态规划的解法 Time O(n^2) Space O(n^2)
public String longestPalindrome(String s) {
    if(s == null || s.length()==0)
        return "";
    boolean[][] palin = new boolean[s.length()][s.length()];
    String res = "";
    int maxLen = 0;
    for(int i=s.length()-1;i>=0;i--)
    {
        for(int j=i;j<s.length();j++)
        {
            if(s.charAt(i)==s.charAt(j) && (j-i<=2 || palin[i+1][j-1]))
            {
                palin[i][j] = true;
                if(maxLen<j-i+1)
                {
                    maxLen=j-i+1;
                    res = s.substring(i,j+1);
                }
            }
        }
    }
    return res;
}

//之前的解法
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