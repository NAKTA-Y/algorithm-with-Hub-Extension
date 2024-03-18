import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

enum Type {
    SANGKUN,
    FIRE
}

class Cell {
    int x;
    int y;
    int time;
    Type type;

    public Cell(int x, int y, int time, Type type) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.type = type;
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int testCase = 0; testCase < testCases; testCase++) {
            String[] lengthLine = reader.readLine().split(" ");
            int width = Integer.parseInt(lengthLine[0]);
            int height = Integer.parseInt(lengthLine[1]);
            char[][] maze = new char[height][width];
            int answer = -1;

            int[] sangkunStartPosition = {0, 0};
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            Queue<Cell> queue = new LinkedList<>();
            boolean[][] visited = new boolean[height][width];

            for (int i = 0; i < height; i++) {
                char[] row = reader.readLine().toCharArray();
                for (int j = 0; j < width; j++) {
                    char c = row[j];
                    if (c == '@') {
                        sangkunStartPosition = new int[]{i, j};
                        visited[i][j] = true;
                    }

                    if (c == '*') {
                        queue.add(new Cell(i, j, 1, Type.FIRE));
                        visited[i][j] = true;
                    }

                    maze[i][j] = row[j];
                }
            }

            queue.add(new Cell(sangkunStartPosition[0], sangkunStartPosition[1], 1, Type.SANGKUN));

            while (!queue.isEmpty()) {
                Cell cell = queue.poll();
                int x = cell.x;
                int y = cell.y;

                // 가장자리 도달 여부
                if (cell.type == Type.SANGKUN
                        && (x == 0 || x == height - 1 || y == 0 || y == width - 1)) {
                    answer = cell.time;
                    break;
                }

                // 상하좌우
                for (int i = 0; i < 4; i++) {
                    int dx = x + directions[i][0];
                    int dy = y + directions[i][1];

                    if (dx < 0 || dy < 0 || dx >= height || dy >= width) continue;
                    if (visited[dx][dy] || maze[dx][dy] != '.') continue;

                    visited[dx][dy] = true;
                    queue.add(new Cell(dx, dy, cell.time + 1, cell.type));
                }
            }

            if (answer > 0) System.out.println(answer);
            else System.out.println("IMPOSSIBLE");
        }
    }
}