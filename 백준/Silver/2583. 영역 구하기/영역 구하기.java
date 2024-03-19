import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int height = Integer.parseInt(info[0]);
        int width = Integer.parseInt(info[1]);
        int k = Integer.parseInt(info[2]);

        List<Integer> answer = new ArrayList<>();
        int[][] board = new int[height][width];
        boolean[][] visited = new boolean[height][width];

        for (int i = 0; i < k; i++) {
            String[] positionInfo = reader.readLine().split(" ");
            int leftUpX = Integer.parseInt(positionInfo[1]);
            int leftUpY = Integer.parseInt(positionInfo[0]);
            int rightDownX = Integer.parseInt(positionInfo[3]) - 1;
            int rightDownY = Integer.parseInt(positionInfo[2]) - 1;

            for (int j = leftUpX; j <= rightDownX; j++) {
                for (int l = leftUpY; l <= rightDownY; l++) {
                    board[j][l] = 1;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    answer.add(bfs(board, visited, i, j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        answer.stream().sorted().forEach(i -> sb.append(i).append(" "));

        System.out.println(answer.size());
        System.out.println(sb);
    }

    private static int bfs(int[][] board, boolean[][] visited, int startX, int startY) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;

        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            answer++;

            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];

            for (int i = 0; i < 4; i++) {
                int dx = x + directions[i][0];
                int dy = y + directions[i][1];

                if (dx < 0 || dy < 0 || dx >= board.length || dy >= board[0].length) continue;
                if (board[dx][dy] != 0 || visited[dx][dy]) continue;

                visited[dx][dy] = true;
                queue.add(new int[] {dx, dy});
            }
        }

        return answer;
    }
}