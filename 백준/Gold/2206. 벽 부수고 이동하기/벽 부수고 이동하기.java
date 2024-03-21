import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position {
    int x;
    int y;
    int destroyed;
    int count;

    public Position(int x, int y, int destroyed, int count) {
        this.x = x;
        this.y = y;
        this.destroyed = destroyed;
        this.count = count;
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInfo = reader.readLine().split(" ");
        int height = Integer.parseInt(sizeInfo[0]);
        int width = Integer.parseInt(sizeInfo[1]);

        int[][] board = new int[height][width];
        boolean[][][] visited = new boolean[2][height][width];

        for (int i = 0; i < height; i++) {
            String[] row = reader.readLine().split("");
            for (int k = 0; k < width; k++) {
                board[i][k] = Integer.parseInt(row[k]);
            }
        }

        int answer = bfs(board, visited);
        System.out.println(answer);
    }

    private static int bfs(int[][] board, boolean[][][] visited) {
        int height = board.length;
        int width = board[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Position> queue = new LinkedList<>();
        int answer = -1;

        queue.add(new Position(0, 0, 0, 1));
        visited[0][0][0] = true;
        visited[1][0][0] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int x = position.x;
            int y = position.y;
            int destroyed = position.destroyed;

            if (x == height-1 && y == width-1) {
                return position.count;
            }

            for (int i = 0; i < 4; i++) {
                int dx = x + directions[i][0];
                int dy = y + directions[i][1];

                if (dx < 0 || dy < 0 || dx >= height || dy >= width) continue;

                if (board[dx][dy] == 1) {
                    if (destroyed == 0) {
                        queue.add(new Position(dx, dy, 1, position.count+1));
                        visited[1][dx][dy] = true;
                    }
                } else {
                    if (!visited[destroyed][dx][dy]) {
                        queue.add(new Position(dx, dy, destroyed, position.count+1));
                        visited[destroyed][dx][dy] = true;
                    }
                }
            }
        }

        return answer;
    }
}