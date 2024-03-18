import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Tomato {
    int z;
    int x;
    int y;
    int ripenDay;

    public Tomato(int z, int x, int y, int ripenDay) {
        this.z = z;
        this.x = x;
        this.y = y;
        this.ripenDay = ripenDay;
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInfo = reader.readLine().split(" ");
        int width = Integer.parseInt(sizeInfo[0]);
        int height = Integer.parseInt(sizeInfo[1]);
        int floor = Integer.parseInt(sizeInfo[2]);

        // init data
        int[][][] field = new int[floor][height][width];
        boolean[][][] visited = new boolean[floor][height][width];
        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < height; j++) {
                String[] row = reader.readLine().split(" ");
                for (int k = 0; k < width; k++) {
                    int tomato = Integer.parseInt(row[k]);
                    if (tomato == 1) {
                        queue.add(new Tomato(i, j, k, 0));
                        visited[i][j][k] = true;
                    }
                    field[i][j][k] = tomato;
                }
            }
        }

        int answer = bfs(field, visited, queue);

        if (isAllRipe(field, visited)) System.out.println(answer);
        else System.out.println(-1);
    }

    private static boolean isAllRipe(int[][][] field, boolean[][][] visited) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                for (int k = 0; k < field[0][0].length; k++) {
                    if (field[i][j][k] == 0 && !visited[i][j][k])
                        return false;
                }
            }
        }

        return true;
    }

    private static int bfs(int[][][] field, boolean[][][] visited, Queue<Tomato> queue) {
        int floor = field.length;
        int height = field[0].length;
        int width = field[0][0].length;

        int[][] directions = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
        int afterDays = 0;

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            afterDays = Math.max(afterDays, tomato.ripenDay);
            int z = tomato.z;
            int x = tomato.x;
            int y = tomato.y;

            for (int i = 0; i < 6; i++) {
                int dz = z + directions[i][0];
                int dx = x + directions[i][1];
                int dy = y + directions[i][2];

                if (dx < 0 || dy < 0 || dz < 0 || dx >= height|| dy >= width || dz >= floor)
                    continue;
                if (visited[dz][dx][dy] || field[dz][dx][dy] != 0)
                    continue;

                queue.add(new Tomato(dz, dx, dy, tomato.ripenDay+1));
                visited[dz][dx][dy] = true;
            }
        }

        return afterDays;
    }
}