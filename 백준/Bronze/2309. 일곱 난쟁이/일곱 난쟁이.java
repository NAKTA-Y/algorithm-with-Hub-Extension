import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int[] heights = new int[9];
            for (int i = 0; i < 9; i++) {
                heights[i] = sc.nextInt();
            }

            Arrays.sort(heights);

            for (int i = 0; i < 9; i++) {
                for (int j = i+1; j < 9; j++) {
                    if (isSum100(heights, i, j)) {
                        print(heights, i, j);
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static boolean isSum100(int[] heights, int i, int j) {
        int sum  = 0;
        for (int k = 0; k < 9; k++) {
            if (k == i || k == j) {
                continue;
            }
            sum += heights[k];
        }

        return sum == 100;
    }

    private static void print(int[] heights, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k == i || k == j) {
                continue;
            }
            System.out.println(heights[k]);
        }
    }
}