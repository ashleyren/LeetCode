public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        
        int minLen = strs[0].length();
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() < minLen) minLen = strs[i].length();
        }
        StringBuilder res = new StringBuilder();
        String baseline = strs[0];
        for(int i = 0; i < minLen ; i++){
            for(String str :strs){
                if(str.charAt(i) != baseline.charAt(i)){
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}