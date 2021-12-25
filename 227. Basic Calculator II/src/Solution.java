class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int curNum = 0;
        char operation = '+';

        for (int i = 0; i < len; i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)) {
                curNum = curNum*10 + (curChar - '0');
            }

            if (!Character.isDigit(curChar) && !Character.isWhitespace(curChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-curNum);
                } else if (operation == '+') {
                    stack.push(curNum);
                } else if (operation == '*') {
                    stack.push(stack.pop()*curNum);
                } else if (operation == '/') {
                    stack.push(stack.pop()/curNum);
                }
                operation = curChar;
                curNum = 0;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}