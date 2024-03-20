import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position {
    int x;
    int y;
    int z;
    int count;

    public Position(int x, int y, int z, int count) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] sizeInfo = reader.readLine().split(" ");
            int floor = Integer.parseInt(sizeInfo[0]);
            int height = Integer.parseInt(sizeInfo[1]);
            int width = Integer.parseInt(sizeInfo[2]);

            if (floor == 0 && height == 0 && width == 0) break;

            char[][][] cube = new char[floor][height][width];
            boolean[][][] visited = new boolean[floor][height][width];
            Position startPosition = null;

            for (int i = 0; i < floor; i++) {
                for (int j = 0; j < height; j++) {
                    char[] row = reader.readLine().toCharArray();
                    for (int k = 0; k < width; k++) {
                        if (row[k] == 'S') startPosition = new Position(j, k, i, 0);
                        cube[i][j][k] = row[k];
                    }
                }
                reader.readLine();
            }

            int answer = bfs(cube, visited, startPosition);

            if (answer < 0) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + answer + " minute(s).");
            }
        }
    }

    private static int bfs(char[][][] cube, boolean[][][] visited, Position startPosition) {
        int floor = cube.length;
        int height = cube[0].length;
        int width = cube[0][0].length;

        int[][] directions = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
        Queue<Position> queue = new LinkedList<>();
        int answer = -1;

        queue.add(startPosition);
        visited[startPosition.z][startPosition.x][startPosition.y] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int x = position.x;
            int y = position.y;
            int z = position.z;

            if (cube[z][x][y] == 'E') {
                return position.count;
            }

            for (int i = 0; i < 6; i++) {
                int dx = x + directions[i][0];
                int dy = y + directions[i][1];
                int dz = z + directions[i][2];

                if (dz < 0 || dx < 0 || dy < 0 || dz >= floor || dx >= height || dy >= width) continue;
                if (visited[dz][dx][dy] || cube[dz][dx][dy] == '#') continue;

                visited[dz][dx][dy] = true;
                queue.add(new Position(dx, dy, dz, position.count+1));
            }
        }

        return answer;
    }
}