class Temp {
    int temp;
    int index;

    Temp (int temp, int index) {
        this.temp = temp;
        this.index = index;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Temp> stack = new Stack<>();

        int len = temperatures.length;
        int[] answer = new int[len];

        for (int i = len-1; i >= 0; i--) {
            int days = 0;
            
            while (!stack.isEmpty() && stack.peek().temp <= temperatures[i]) {
                Temp pop = stack.pop();

                days += answer[pop.index];
            }

            answer[i] = stack.isEmpty() ? 0 : days + 1;

            stack.push(new Temp(temperatures[i], i));
        }

        return answer;
    }
}