import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        List<String> operations = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        int sequenceIndex = 0;
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && (stack.peek() == sequence[sequenceIndex])) {
                sequenceIndex++;
                stack.pop();
                operations.add("-");
            }
            stack.push(i);
            operations.add("+");
        }

        while (!stack.isEmpty()) {
            if (sequence[sequenceIndex++] != stack.peek()) {
                System.out.println("NO");
                System.exit(0);
            }
            stack.pop();
            operations.add("-");
        }

        for (String operation : operations) {
            System.out.println(operation);
        }
    }
}