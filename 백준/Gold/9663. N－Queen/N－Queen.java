import java.util.Scanner;

public class Main {
    static int n;
    static int[] col;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        col = new int[n + 1];
        int answer = dfs(1);

        System.out.println(answer);

        sc.close();
    }

    static int dfs(int row) {
        if (row == n + 1) {
            return 1;
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            col[row] = i;

            if (check(row)) {
                count += dfs(row + 1);
            }
        }

        return count;
    }

    static boolean check(int row) {
        for (int i = 1; i < row; i++) {
            if (col[i] == col[row]) {
                return false;
            }

            if (Math.abs(col[i] - col[row]) == row - i) {
                return false;
            }
        }

        return true;
    }
}