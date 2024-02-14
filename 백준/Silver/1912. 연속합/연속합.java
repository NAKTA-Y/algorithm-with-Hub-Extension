import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int length = sc.nextInt();
            int[] sequence = new int[length];
            int[] cumulativeSum = new int[length];

            for (int i = 0; i < length; i++) {
                int number = sc.nextInt();
                sequence[i] = number;
            }

            cumulativeSum[0] = sequence[0];
            int max = cumulativeSum[0];

            for (int i = 1; i < length; i++) {
                cumulativeSum[i] = Math.max(sequence[i], cumulativeSum[i-1] + sequence[i]);
                max = Math.max(max, cumulativeSum[i]);
            }

            System.out.println(max);
        }
    }
}