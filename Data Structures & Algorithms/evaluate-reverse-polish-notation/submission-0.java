class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();

        for(String t : tokens) {
            if(t.equals("*") || t.equals("/") || t.equals("+") || t.equals("-")) {
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(calculate(bottom, top, t));
                continue;
            }
            stack.push(Integer.parseInt(t));
        }
        return stack.pop();
    }

    public int calculate(int a, int b, String operator) {
        switch(operator) {
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            default:
                return a + b;

        }
    }
}
