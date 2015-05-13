public class Solution {
   
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        if(wordBreakCheck(s,dict)) helper(s,dict,0,"",res);
        return res;
    }
     private boolean wordBreakCheck(String s, Set<String> dict) {
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
    private void helper(String s, Set<String> dict, int l, String item, ArrayList<String> res){
        if(l >= s.length()){
            res.add(item);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = l; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(dict.contains(sb.toString())){
                String newItem = new String();
                if(item == null || item.length() == 0){
                    newItem = sb.toString();
                }else{
                    newItem = item + " " + sb.toString();
                } 
                helper(s,dict,i+1,newItem,res);//这里是i+1，不是l+1 这样才能保证它每次是增加的 不然就变了。。。
            }
        }
    }
}