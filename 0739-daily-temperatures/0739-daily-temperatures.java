class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int len = temps.length;
        int[] answer = new int[len];

        for (int i = len-2; i >= 0; i--) {
            int index = i+1;
            while (temps[index] <= temps[i] && answer[index] != 0) {
                answer[i] += answer[index];
                index += answer[index];
            }

            if (temps[index] > temps[i]) answer[i] += 1;
            else answer[i] = 0;
        }

        return answer;
    }
}