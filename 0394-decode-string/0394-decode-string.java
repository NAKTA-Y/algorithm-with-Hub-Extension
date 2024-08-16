class Solution {
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        Deque<Integer> countStack = new ArrayDeque<>();
        StringBuilder recent = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(num);
                num = 0;
                stack.push(recent.toString());
                recent = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder(stack.pop());
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(recent);
                }
                recent = temp;
            } else {
                recent.append(c);
            }
        }

        return recent.toString();
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}