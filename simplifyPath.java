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