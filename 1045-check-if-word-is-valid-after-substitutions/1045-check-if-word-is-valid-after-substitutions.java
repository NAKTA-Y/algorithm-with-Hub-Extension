class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') return false;
                if (stack.isEmpty() || stack.pop() != 'a') return false;
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}