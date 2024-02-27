import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws IOException {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            if (number == 0) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}
