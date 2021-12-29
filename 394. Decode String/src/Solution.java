class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for (char c:s.toCharArray()) {
            if (c == ']') {
                while (stack.peek() != '[') {
                    temp.append(stack.pop());
                }
                stack.pop();
                String decodedString = temp.reverse().toString();
                int k = 0, base = 1;

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() -'0')*base;
                    base *= 10;
                }

                for (int i = 0; i < k; i++) {
                    for (char ch:decodedString.toCharArray()) {
                        stack.push(ch);
                    }
                }
                temp.setLength(0);
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}