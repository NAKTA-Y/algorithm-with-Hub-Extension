import java.util.*;
import java.io.*;

class Tomato {
    int x;
    int y;
    int ripensDay;

    public Tomato(int x, int y, int ripensDay) {
        this.x = x;
        this.y = y;
        this.ripensDay = ripensDay;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] lengthLine = reader.readLine().split(" ");
        int width = Integer.parseInt(lengthLine[0]);
        int height = Integer.parseInt(lengthLine[1]);
        int[][] field = new int[height][width];
        int answer = 0;

        Queue<Tomato> queue = new LinkedList<>();
        boolean[][] visited = new boolean[height][width];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < height; i++) {
            String[] tomatoLine = reader.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                int tomatoStatus = Integer.parseInt(tomatoLine[j]);
                if (tomatoStatus == 1) {
                    queue.add(new Tomato(i, j, 0));
                    visited[i][j] = true;
                }
                field[i][j] = tomatoStatus;
            }
        }

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            answer = tomato.ripensDay;
            int x = tomato.x;
            int y = tomato.y;

            for (int i = 0; i < 4; i++) {
                int dx = x + directions[i][0];
                int dy = y + directions[i][1];

                if (dx < 0 || dy < 0 || dx >= height || dy >= width) continue;
                if (field[dx][dy] != 0 || visited[dx][dy]) continue;

                queue.add(new Tomato(dx, dy, tomato.ripensDay + 1));
                visited[dx][dy] = true;
            }
        }

        if (allRipens(field, visited, height, width)) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean allRipens(int[][] field, boolean[][] visited, int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!visited[i][j] && field[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}