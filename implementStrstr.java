public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            boolean flag = true;
            for(int j = 0; j < needle.length(); j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag) return i;
        }
        return -1;
    }
}
//注意边界问题啊。。。错了 还有看清楚题目