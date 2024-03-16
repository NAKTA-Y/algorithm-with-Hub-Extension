import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] lengthLine = reader.readLine().split(" ");
        int height = Integer.parseInt(lengthLine[0]);
        int width = Integer.parseInt(lengthLine[1]);
        int[][] canvas = new int[height][width];
        int count = 0;
        int maxArea = 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[height][width];
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 좌 우 하 상

        // init data
        for (int i = 0; i < height; i++) {
            String[] paints = reader.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                canvas[i][j] = Integer.parseInt(paints[j]);
            }
        }

        // search
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (canvas[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                count++;
                int area = 1;
                queue.add(new int[] {i, j});
                visited[i][j] = true;
                // bfs
                while (!queue.isEmpty()) {
                    int x = queue.peek()[0];
                    int y = queue.peek()[1];
                    queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int dx = x + direction[k][0];
                        int dy = y + direction[k][1];

                        if (dx < 0 || dy < 0 || dx >= height || dy >= width)
                            continue;
                        if (canvas[dx][dy] != 1 || visited[dx][dy])
                            continue;

                        area++;
                        queue.add(new int[] {dx, dy});
                        visited[dx][dy] = true;
                    }
                }
                maxArea = Math.max(maxArea, area);
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }
}