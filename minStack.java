class MinStack {
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> minS = new Stack<Integer>();
    public void push(int x) {
        s.push(x);
        if(minS.isEmpty() || x <= minS.peek() ){
            minS.push(x);
        }
    }

    public void pop() {
        if(s.isEmpty()) return;
        int top = s.peek();
        s.pop();
        if(!minS.isEmpty() && top == minS.peek()){
            minS.pop();
        }
    }

    public int top() {
        if(s.isEmpty()){
            return 0;
        } else {
            return s.peek();
        }
    }

    public int getMin() {
        if(minS.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return minS.peek();
        }
        
    }
}
// 这道题目的精髓是minS 并且一定一定要记得 每次都check两个stack是不是空的 是空的咋办！