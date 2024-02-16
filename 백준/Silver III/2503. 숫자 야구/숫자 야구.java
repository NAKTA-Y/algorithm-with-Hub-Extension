import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static int ANSWER = 0;
    private static boolean[] visited = new boolean[10];

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Map<String, int[]> roundInfoMap = new HashMap<>();
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                String[] roundInfo = line.split(" ");
                int[] strikeBalls = new int[2];

                String expectNumber = roundInfo[0];
                strikeBalls[0] = Integer.parseInt(roundInfo[1]);
                strikeBalls[1] = Integer.parseInt(roundInfo[2]);

                roundInfoMap.put(expectNumber, strikeBalls);
            }

            dfs(new char[3], 0, roundInfoMap);

            System.out.println(ANSWER);
        }
    }
    
    private static void dfs(char[] number, int index, Map<String, int[]> roundInfoMap) {
        if (index == 3) {
            calculateMatch(number, roundInfoMap);
            return;
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                number[index] = (char) (i + '0');
                visited[i] = true;
                dfs(number, index + 1, roundInfoMap);
                visited[i] = false;
            }
        }
    }

    private static void calculateMatch(char[] number, Map<String,int[]> roundInfoMap) {
        for (String key : roundInfoMap.keySet()) {
            int strike = 0;
            int ball = 0;

            for (int i = 0; i < number.length; i++) {
                if (key.charAt(i) == number[i]) {
                    strike++;
                } else if (key.contains(String.valueOf(number[i]))) {
                    ball++;
                }
            }

            if (roundInfoMap.get(key)[0] != strike || roundInfoMap.get(key)[1] != ball) {
                return;
            }
        }

        ANSWER++;
    }
}