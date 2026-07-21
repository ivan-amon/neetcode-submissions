class Solution {
    public boolean isValid(String s) {

        Deque<Character> strStack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                strStack.push(c);
                continue;
            }

            if(strStack.isEmpty()) return false;
            if(!check(c, strStack.pop())) return false;
        }

        if(!strStack.isEmpty()) return false;
        return true;
    }

    boolean check(char c, char popped) {
        if(c == ')') {
            if(popped != '(') return false;
        }
        if(c == '}') {
            if(popped != '{') return false;
        }
        if(c == ']') {
            if(popped != '[') return false;
        }
        return true;
    }
}
