import java.util.Arrays;

class Solution {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];

        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }

        for (int i = 1; i < map.length; i++) {
            map[i][0] = map[i][0] == -1 || map[i-1][0] == -1 ? -1 : 1;
        }

        for (int i = 1; i < map[0].length; i++) {
            map[0][i] = map[0][i] == -1 || map[0][i-1] == -1 ? -1 : 1;
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                if (map[i][j] == -1) continue;
                map[i][j] = map[i-1][j] + map[i][j-1];

                if (map[i-1][j] == -1 || map[i][j-1] == -1) {
                    map[i][j]++;
                }

                map[i][j] = map[i][j] % 1000000007;
            }
        }

        return map[map.length-1][map[0].length-1] == -1 ? 0 : map[map.length-1][map[0].length-1];
    }
}