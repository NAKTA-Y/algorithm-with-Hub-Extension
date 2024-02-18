import java.util.Scanner;

public class Main {
    private static int ANSWER = 0;
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            dfs(array, 0, 0, s);

            System.out.println(s == 0 ? ANSWER - 1 : ANSWER);
        }
    }

    private static void dfs(int[] array, int index, int sum, int target) {
        if (index == array.length) {
            if (sum == target) {
                ANSWER++;
            }
            return;
        }

        dfs(array, index+1, sum + array[index], target);
        dfs(array, index+1, sum, target);
    }
}