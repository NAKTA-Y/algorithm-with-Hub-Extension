import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.Predicate;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < testCases; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            char[] commands = reader.readLine().toCharArray();

            reader.readLine();
            String numberLine = reader.readLine();
            String removedBracket = numberLine.substring(1, numberLine.length() - 1);
            Arrays.stream(removedBracket.split(","))
                    .filter(Predicate.not(String::isEmpty))
                    .mapToInt(Integer::parseInt)
                    .forEach(deque::add);

            boolean isStack = false;
            boolean isError = false;
            for (char command : commands) {
                switch (command) {
                    case 'R':
                        isStack = !isStack;
                        break;
                    case 'D':
                        if (deque.isEmpty()) {
                            isError = true;
                            break;
                        }

                        if (isStack) deque.pollLast();
                        else         deque.pollFirst();
                }
            }

            if (isError) {
                System.out.println("error");
            } else if (!deque.isEmpty()) {
                while (!deque.isEmpty()) {
                    if (isStack)
                        sb.append(deque.pollLast()).append(",");
                    else
                        sb.append(deque.pollFirst()).append(",");
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append("]");
                System.out.println(sb);
            } else {
                sb.append("]");
                System.out.println(sb);
            }
        }

        reader.close();
    }
}