import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());

        List<Integer> answer = new ArrayList<>();
        int[][] board = new int[length][length];
        boolean[][] visited = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            String[] row = reader.readLine().split("");
            for (int j = 0; j < length; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    answer.add(bfs(board, visited, i, j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        answer.stream().sorted().forEach(i -> sb.append(i).append(System.lineSeparator()));

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
                if (board[dx][dy] != 1 || visited[dx][dy]) continue;

                visited[dx][dy] = true;
                queue.add(new int[] {dx, dy});
            }
        }

        return answer;
    }
}