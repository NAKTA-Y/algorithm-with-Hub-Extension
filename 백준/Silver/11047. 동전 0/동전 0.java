import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int answer = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            Integer[] values = new Integer[n];

            for (int i = 0; i < n; i++) {
                values[i] = sc.nextInt();
            }

            Arrays.sort(values, Collections.reverseOrder());

            int index = 0;
            while (k > 0) {
                while (values[index] <= k) {
                    k -= values[index];
                    answer++;
                }
                index++;
            }

            System.out.println(answer);
        }
    }
}