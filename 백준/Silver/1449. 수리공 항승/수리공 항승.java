import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int coverLength = 0;
            int answer = 0;
            int n = sc.nextInt();
            int l = sc.nextInt();
            int[] holes = new int[n];

            for (int i = 0; i < n; i++) {
                holes[i] = sc.nextInt();
            }

            Arrays.sort(holes);

            for (int hole : holes) {
                if (coverLength < hole) {
                    coverLength = hole + l - 1;
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}