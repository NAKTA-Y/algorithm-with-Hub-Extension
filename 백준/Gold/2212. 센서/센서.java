import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int answer = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] sensors = new int[n];
            int[] distances = new int[n-1];

            for (int i = 0; i < n; i++) {
                sensors[i] = sc.nextInt();
            }

            Arrays.sort(sensors);

            for (int i = sensors.length-1, j = 0; i > 0; i--, j++) {
                distances[j] = sensors[i] - sensors[i-1];
            }

            Arrays.sort(distances);

            for (int i = 0; i < distances.length - (k - 1); i++) {
                answer += distances[i];
            }

            System.out.println(answer);
        }
    }
}