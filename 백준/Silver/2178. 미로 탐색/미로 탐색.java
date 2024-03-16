import java.util.*;
import java.io.*;

class Cell {
    int x;
    int y;
    int length;

    public Cell(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] lengthLine = reader.readLine().split(" ");
        int height = Integer.parseInt(lengthLine[0]);
        int width = Integer.parseInt(lengthLine[1]);
        int[][] maze = new int[height][width];
        int answer = 1;

        Queue<Cell> queue = new LinkedList<>();
        boolean[][] visited = new boolean[height][width];
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // init data
        for (int i = 0; i < height; i++) {
            String[] pathLine = reader.readLine().split("");
            for (int j = 0; j < width; j++) {
                maze[i][j] = Integer.parseInt(pathLine[j]);
            }
        }

        // bfs
        queue.add(new Cell(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            if (queue.peek().x == height - 1 && queue.peek().y == width - 1) {
                break;
            }

            Cell cell = queue.poll();
            int x = cell.x;
            int y = cell.y;

            for (int i = 0; i < 4; i++) {
                int dx = x + direction[i][0];
                int dy = y + direction[i][1];

                if (dx < 0 || dy < 0 || dx >= height || dy >= width) continue;
                if (maze[dx][dy] != 1 || visited[dx][dy]) continue;

                queue.add(new Cell(dx, dy, cell.length+1));
                visited[dx][dy] = true;
            }
            answer++;
        }

        System.out.println(queue.poll().length);
    }
}