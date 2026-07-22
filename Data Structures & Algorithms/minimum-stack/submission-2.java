class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        stack.push(val);
        if(val <= minStack.peek()) {
            minStack.push(val);
        };
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == minStack.peek()) minStack.pop();
    }
    
    public int top() {
        int val = stack.peek();
        return val;
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
