/*
这道题就是for循环要逆序
split(" ")要熟练
sb.length() 和 substring() 也要熟练
还有循环完了要判断sb是不是空如果是空就返回空字符串。
最重要的就是要判断array[i]是不是空的字符串
split会出现empty string的原因是 如果开头就分隔符（空格），分隔符前面的内容也自动成为一个子项，尽管没东西--》empty string
例子
",test" split ','
and

",test," split ','
will return an array of size 2. Everything before the first match is returned as the first element.
*/
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = array.length-1; i>=0;i--){
            if(!array[i].equals("")){ //这一步很重要
                sb.append(array[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0,sb.length()-1);
    }
}