import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        char[][] paints = new char[size][size];
        int noBlindnessCount = 0;
        int blindnessCount = 0;

        for (int i = 0; i < size; i++) {
            paints[i] = reader.readLine().toCharArray();
        }

        // 일반인 기준 bfs
        boolean[][] visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    noBlindnessCount++;
                    bfs(paints, visited, i, j);
                }
            }
        }

        // 적록색약 그림으로 변경
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (paints[i][j] == 'G') paints[i][j] = 'R';
            }
        }

        // 적록색약 기준 bfs
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    blindnessCount++;
                    bfs(paints, visited, i, j);
                }
            }
        }

        System.out.println(noBlindnessCount + " " + blindnessCount);
    }

    private static void bfs(char[][] field, boolean[][] visited, int startX, int startY) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {startX, startY});
        while (!queue.isEmpty()) {
            int[] positions = queue.poll();
            int x = positions[0];
            int y = positions[1];

            for (int i = 0; i < 4; i++) {
                int dx = x + directions[i][0];
                int dy = y + directions[i][1];

                if (dx < 0 || dy < 0 || dx >= field.length || dy >= field[0].length)
                    continue;
                if (visited[dx][dy] || field[dx][dy] != field[x][y])
                    continue;

                queue.add(new int[] {dx, dy});
                visited[dx][dy] = true;
            }
        }
    }
}