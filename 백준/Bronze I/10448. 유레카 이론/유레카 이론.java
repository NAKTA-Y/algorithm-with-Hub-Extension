import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<Integer> sumList = new ArrayList<>();
            for (int i = 1; i <= 44; i++)
                sumList.add( i * (i + 1) / 2);

            int testCases = sc.nextInt();

            for (int i = 0; i < testCases; i++) {
                int target = sc.nextInt();

                if (isEureka(target, sumList)) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        }
    }

    private static boolean isEureka(int target, List<Integer> sumList) {
        for (Integer sum1 : sumList) {
            for (Integer sum2 : sumList) {
                for (Integer sum3 : sumList) {
                    if (target == (sum1 + sum2 + sum3)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
