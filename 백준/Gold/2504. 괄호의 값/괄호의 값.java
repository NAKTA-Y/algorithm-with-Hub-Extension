import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String brackets = " " + reader.readLine() + " ";

        if (!isCorrect(brackets)) {
            System.out.println(0);
            System.exit(0);
        }

        long answer = calculate(brackets);
        System.out.println(answer);
    }

    public static long calculate(String subString) {
        long answer = 0;
        if (subString.length() == 2) {
            if (subString.charAt(1) == ')') {
                return 2;
            } else {
                return 3;
            }
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        stack.add(subString.charAt(1));
        builder.append(subString.charAt(1));

        for (int i = 2; i < subString.length()-1; i++) {
            builder.append(subString.charAt(i));

            if (subString.charAt(i) == ')' || subString.charAt(i) == ']') {
                stack.pop();
            } else {
                stack.add(subString.charAt(i));
            }

            if (stack.isEmpty()) {
                answer += calculate(builder.toString());
                builder = new StringBuilder();
            }
        }

        if (subString.charAt(0) == '(')  {
            return 2 * answer;
        } else if (subString.charAt(0) == '['){
            return 3 * answer;
        } else {
            return 1 * answer;
        }
    }
    
    public static boolean isCorrect(String brackets) {
        Stack<Character> stack = new Stack<>();
        char[] chunks = brackets.toCharArray();

        for (char chunk : chunks) {
            if (chunk == ')' || chunk == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
            }
            if (chunk == ')' && stack.peek() == '('
                || chunk == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (chunk == '(' || chunk == '['){
                stack.push(chunk);
            }
        }

        return stack.isEmpty();
    }
}