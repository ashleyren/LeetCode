public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    
        int len = s.length();
        if(len < 1) return 0;
        
        else{
            
            int n = len - 1;
            int k =0;
            int flag = 0;
            while(n>=0 && flag != 2){
              if(flag ==1 && s.charAt(n) == ' '){
                   flag =2;
               }else if(s.charAt(n) != ' '){
                   k++;
                   flag = 1;
        
               }
               n--;
            }
            
            if(flag != 0){
                return k;
            }else{
                return 0;
            }
        }
        
    }
}