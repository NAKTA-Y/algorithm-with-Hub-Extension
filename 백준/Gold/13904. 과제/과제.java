import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int answer = 0;
            int n = sc.nextInt();
            List<int[]> tasks = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                int[] task = new int[2];
                task[0] = sc.nextInt();
                task[1] = sc.nextInt();
                tasks.add(task);
            }

            for (int i = n; i >= 1; i--) {
                int max = 0;
                int index = -1;
                for (int j = 0; j < tasks.size(); j++) {
                    if (i <= tasks.get(j)[0] && max < tasks.get(j)[1]) {
                        max = tasks.get(j)[1];
                        index = j;
                    }
                }

                if (index >= 0) {
                    answer += max;
                    tasks.remove(index);
                }
            }

            System.out.println(answer);
        }
    }
}