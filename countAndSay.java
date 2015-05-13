public class Solution {
    public String countAndSay(int n) {
        if(n < 0) return null;
        String curRes = "1";
        for(int i = 2; i < n+1 ; i++){
            StringBuilder res = new StringBuilder();
            int count = 1;
            int j;
            for(j = 0; j < curRes.length() - 1; j++){
                if(curRes.charAt(j) == curRes.charAt(j+1)){
                    count++;
                } else {
                    res.append(count);
                    res.append(curRes.charAt(j));
                    count = 1;
                }
            }
            res.append(count);
            res.append(curRes.charAt(curRes.length() - 1));
            curRes = res.toString();
        }
        return curRes;
    }
}