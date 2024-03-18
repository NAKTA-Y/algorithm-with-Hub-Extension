import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Night {
    int x;
    int y;
    int moveCount;

    public Night(int x, int y, int moveCount) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            int l = Integer.parseInt(reader.readLine());
            int[][] board = new int[l][l];
            boolean[][] visited = new boolean[l][l];
            Queue<Night> queue = new LinkedList<>();

            int[] start = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] target = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            queue.add(new Night(start[0], start[1], 0));

            int answer = bfs(board, visited, target, queue);
            System.out.println(answer);
        }
    }

    private static int bfs(int[][] board, boolean[][] visited, int[] target, Queue<Night> queue) {
        int[][] directions = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

        while (!queue.isEmpty()) {
            Night night = queue.poll();
            int x = night.x;
            int y = night.y;

            if (x == target[0] && y == target[1])
                return night.moveCount;

            for (int i = 0; i < 8; i++) {
                int dx = x + directions[i][0];
                int dy = y + directions[i][1];

                if (dx < 0 || dy < 0 || dx >= board.length|| dy >= board[0].length)
                    continue;
                if (visited[dx][dy] || board[dx][dy] != 0)
                    continue;

                queue.add(new Night(dx, dy, night.moveCount+1));
                visited[dx][dy] = true;
            }
        }

        return -1;
    }
}