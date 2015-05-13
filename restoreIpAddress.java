public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        helper(s, 0, 1, "", res);
        return res;
    }
    private void helper(String s, int start, int segment, String item, ArrayList<String> res){
        if(start >= s.length()){
            return;
        }
        if(segment == 4){
            String str = s.substring(start);
            if(isValid(str)){
                res.add(item + "." + str);
            }
            return;
        }
        
        for(int i = 1; i < 4 &&(start + i <= s.length()); i++){
            String str = s.substring(start, start + i);
            if(isValid(str)){
                if(segment == 1){
                    helper(s,start+i,2,str,res);
                }else{
                    helper(s,start+i,segment+1,item+"."+str,res);
                }
            }
        }
    }
    private boolean isValid(String s){
        if(s == null || s.length() > 3) return false;
        if(s.charAt(0) == '0' && s.length() > 1) return false;
        int num = Integer.parseInt(s);
        if(num >= 0 && num <= 255){
            return true;
        }
        return false;
    }
}