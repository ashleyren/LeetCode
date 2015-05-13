public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){// 妈蛋一定要用equals！！！不然会报错
                stack.push(stack.pop() + stack.pop());
            }else if(tokens[i].equals("-")){
                stack.push(-stack.pop() + stack.pop());
            }else if(tokens[i].equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(tokens[i].equals("/")){
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1/op2);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

}