class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> valueStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        int len = temperatures.length;
        int[] answer = new int[len];

        for (int i = len-1; i >= 0; i--) {
            int days = 0;
            
            while (!valueStack.isEmpty() && valueStack.peek() <= temperatures[i]) {
                valueStack.pop();
                int index = indexStack.pop();

                days += answer[index];
            }

            answer[i] = valueStack.isEmpty() ? 0 : days + 1;

            valueStack.push(temperatures[i]);
            indexStack.push(i);
        }

        return answer;
    }
}