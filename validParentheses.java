public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty() || s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == '}' && stack.peek() == '{'){
                stack.pop();
            }else if(s.charAt(i) == ']' && stack.peek() == '['){
                stack.pop();
            }else if(s.charAt(i) == ')' && stack.peek() == '('){
                stack.pop();
            }else{
                return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
//不要忘记s的空检查。这个题目思路不难，但是要把代码写的尽量简练不容易。值得思考。