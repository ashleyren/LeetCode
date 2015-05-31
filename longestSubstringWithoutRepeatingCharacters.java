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

//这一次写的代码，其实这题没有什么难度，主要就是使用HashSet来存储这个字符是不是出现在里面。
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int max = 0;
        HashSet<Character> set = new HashSet<Character>();
        int walker = 0; 
        int runner = 0;
        while(runner < s.length()){
            if(!set.contains(s.charAt(runner))){
                set.add(s.charAt(runner));
                runner++;
                max = Math.max(max, runner - walker);
            }else{
                while(s.charAt(walker) != s.charAt(runner)){
                    set.remove(s.charAt(walker));
                    walker++;
                }
                walker++;
                runner++;
            }
        }
        return max;
    }
}