import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            Stack<Character> stack = new Stack<>();
            if (".".equals(line)) {
                System.exit(0);
            }
            char[] lineParts = line.toCharArray();

            for (char part : lineParts) {
                if (part == '(' || part == '[') {
                    stack.push(part);
                } else if (part == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        stack.push(part);
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (part == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        stack.push(part);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}