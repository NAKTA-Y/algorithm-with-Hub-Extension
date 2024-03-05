import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] elements = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Integer> stack = new Stack<>();
        stack.push(elements[n-1]);

        StringBuilder answer = new StringBuilder();
        answer.append("1-");

        for (int i = n-2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= elements[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                answer.append(" ").append("1-");
            } else {
                answer.append(" ").append(new StringBuilder().append(stack.peek()).reverse());
            }

            stack.push(elements[i]);
        }

        System.out.println(answer.reverse());
    }
}