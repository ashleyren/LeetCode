/**思路是：helper(string, 开始，字段，item，res)
isValid函数
这道题目的几个细节：
使用segment是个想法
for语句里面int 从1开始 是位了substring(start+i)的正常。。。不然从0开始就是空了
里面判断要分第一个和其他 其他要加. 第一个则不加
判断isvalid的时候，如果开头是0并且长度大于1的是无效的！注意了
*/

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