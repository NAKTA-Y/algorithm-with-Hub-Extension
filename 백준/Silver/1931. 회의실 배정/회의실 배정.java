import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int answer = 1;
            int n = sc.nextInt();
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return -1;
                }
            });

            for (int i = 0; i < n; i++) {
                int[] time = new int[2];
                time[0] = sc.nextInt();
                time[1] = sc.nextInt();

                queue.add(time);
            }

            int endTime = queue.poll()[1];
            while (!queue.isEmpty()) {
                int[] time = queue.poll();
                if (endTime > time[0]) {
                    continue;
                }
                endTime = time[1];
                answer++;
            }

            System.out.println(answer);
        }
    }
}