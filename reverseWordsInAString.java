/*
这道题就是for循环要逆序
split(" ")要熟练
sb.length() 和 substring() 也要熟练
还有循环完了要判断sb是不是空如果是空就返回空字符串。
*/
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = array.length-1; i>=0;i--){
            if(!array[i].equals("")){
                sb.append(array[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0,sb.length()-1);
    }
}