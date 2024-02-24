import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int answer = 0;
            int n = Integer.parseInt(br.readLine());
            List<int[]> tasks = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                String[] task = br.readLine().split(" ");
                tasks.add(new int[]{Integer.parseInt(task[0]), Integer.parseInt(task[1])});
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