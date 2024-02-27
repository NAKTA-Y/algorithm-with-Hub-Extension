import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            String command = line[0];

            if (command.equals("push")) {
                String number = line[1];
                stack.push(number);
            } else if (command.equals("pop")) {
                System.out.println(stack.isEmpty() ? "-1" : stack.pop());
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.isEmpty() ? "1" : "0");
            } else if (command.equals("top")) {
                System.out.println(stack.isEmpty() ? "-1" : stack.peek());
            }
        }
    }
}