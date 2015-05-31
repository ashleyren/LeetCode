/*
这个题目的思路是，先把这个string按照“/”切分，成为一个string的数组，对数组元素逐个判断。
选择压栈或者是出栈，要注意的事情是:每次出栈的时候要事先判断栈是否为空。
还有这里的stack用Linkedlist实现是因为最后连接的时候，要使用removeLast()这个是LinkedList的方法，Stack则木有。
对数组判断完了之后，如果stack是空就直接返回“/”
*/

public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "";
        LinkedList<String> stack = new LinkedList<String>();
        String[] strs = path.split("/");
        for(String s : strs){
            if(s.length() == 0 || s.equals(".")){
                continue;
            }
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s);
            }
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/").append(stack.removeLast());
        }
        
        return sb.toString();
    }
}