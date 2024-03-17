import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            String[] infoLine = reader.readLine().split(" ");
            int height = Integer.parseInt(infoLine[0]);
            int width = Integer.parseInt(infoLine[1]);
            int cabbageCount = Integer.parseInt(infoLine[2]);
            int answer = 0;

            int[][] field = new int[height][width];
            boolean[][] visited = new boolean[height][width];

            for (int j = 0; j < cabbageCount; j++) {
                String[] positions = reader.readLine().split(" ");
                int x = Integer.parseInt(positions[0]);
                int y = Integer.parseInt(positions[1]);
                field[x][y] = 1;
            }

            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    if (!visited[j][k] && field[j][k] == 1) {
                        answer++;
                        bfs(field, visited, j, k);
                    }
                }
            }

            System.out.println(answer);
        }
    }

    private static void bfs(int[][] field, boolean[][] visited, int startX, int startY) {
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
                if (visited[dx][dy] || field[dx][dy] != 1)
                    continue;

                queue.add(new int[] {dx, dy});
                visited[dx][dy] = true;
            }
        }
    }
}