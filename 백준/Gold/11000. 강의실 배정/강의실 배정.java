import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[][] times = new int[n][2];
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                times[i][0] = sc.nextInt();
                times[i][1] = sc.nextInt();
            }

            Arrays.sort(times, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });

            queue.add(times[0][1]);
            for (int i = 1; i < times.length; i++) {
                if (times[i][0] >= queue.peek()) {
                    queue.poll();
                }
                queue.add(times[i][1]);
            }

            System.out.println(queue.size());
        }
    }
}