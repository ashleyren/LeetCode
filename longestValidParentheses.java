public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int max = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max,i - start + 1);
                    }else{
                        max = Math.max(max,i - stack.peek());
                    }
                }else{
                    start = i + 1;
                }
            }
        }
        return max;
    }
}