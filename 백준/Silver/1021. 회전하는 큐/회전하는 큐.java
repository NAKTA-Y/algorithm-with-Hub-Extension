import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int[] elements = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        for (int element : elements) {
            int move = 0;
            while (true) {
                if (deque.getFirst() == element) {
                    int min = Math.min(deque.size() - move, move);
                    deque.pollFirst();
                    answer += min;
                    break;
                }

                deque.addLast(deque.pollFirst());
                move++;
            }
        }

        System.out.println(answer);
    }
}