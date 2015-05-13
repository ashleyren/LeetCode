public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0 || dict == null) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0 ; i < s.length();i++){
            for(int j = 0; j<=i;j++){
                if(dict.contains(s.substring(j,i+1)) && dp[j] == true){// 这个i+1容易错哇亲
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}