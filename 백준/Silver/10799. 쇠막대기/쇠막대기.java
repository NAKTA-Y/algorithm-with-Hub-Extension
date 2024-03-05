import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] brackets = reader.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        boolean currentIsOpen = false;
        for (char bracket : brackets) {
            if (bracket == ')') {
                stack.pop();
                if (currentIsOpen) {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
                currentIsOpen = false;
            } else {
                currentIsOpen = true;
                stack.push(bracket);
            }
        }

        System.out.println(answer);
        reader.close();
    }
}