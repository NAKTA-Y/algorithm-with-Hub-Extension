import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int testCase = 1;
            while (true) {
                int l = sc.nextInt();
                int p = sc.nextInt();
                int v = sc.nextInt();

                if (l == 0 && p == 0 && v == 0) {
                    break;
                }

                int date = l * (v / p);
                int remainDate = Math.min(l, v % p);

                System.out.println("Case " + testCase++ + ": " + (date + remainDate));
            }
        }
    }
}
