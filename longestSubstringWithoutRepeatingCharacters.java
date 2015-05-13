public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        HashSet<Character> set = new HashSet<Character>();
        int res = 0;
        //runners
        int slow = 0; 
        int fast = 0;
        while(fast < s.length()){
            if(set.contains(s.charAt(fast))){
                if(res < fast - slow) res = fast - slow;
                while(s.charAt(slow) != s.charAt(fast)){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            } else {
                set.add(s.charAt(fast));
            }
            fast++;
        }
        res = Math.max(res,fast - slow);
        return res;
    }
}