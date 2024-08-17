import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    private Deque<int[]> queue = new ArrayDeque<>();
    int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int height = heights.length;
        int width = heights[0].length;

        boolean[][] canPacific = new boolean[height][width];
        boolean[][] canAtlantic = new boolean[height][width];

        // pacific
        for (int i = 0; i < width; i++) {
            if (canPacific[0][i]) continue;
            canPacific[0][i] = true;
            queue.add(new int[] {0, i});
            bfs(heights, canPacific);
        }

        for (int i = 0; i < height; i++) {
            if (canPacific[i][0]) continue;
            canPacific[i][0] = true;
            queue.add(new int[] {i, 0});
            bfs(heights, canPacific);
        }

        // atlantic
        for (int i = 0; i < width; i++) {
            if (canAtlantic[height-1][i]) continue;
            canAtlantic[height-1][i] = true;
            queue.add(new int[] {height-1, i});
            bfs(heights, canAtlantic);
        }

        for (int i = 0; i < height; i++) {
            if (canAtlantic[i][width-1]) continue;
            canAtlantic[i][width-1] = true;
            queue.add(new int[] {i, width-1});
            bfs(heights, canAtlantic);
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (canPacific[i][j] && canAtlantic[i][j]) {
                    List<Integer> both = new ArrayList<>();
                    both.add(i);
                    both.add(j);
                    result.add(both);
                }
            }
        }

        return result;
    }

    public void bfs(int[][] heights, boolean[][] canOcean) {
        int x = 0;
        int y = 0;
        int height = heights.length;
        int width = heights[0].length;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            x = pos[0];
            y = pos[1];

            for (int i = 0; i < 4; i++) {
                int moveX = x + directions[i][0];
                int moveY = y + directions[i][1];

                // out of range
                if (moveX < 0 || moveY < 0 || moveX >= height || moveY >= width) continue;

                // can overflow
                if (heights[moveX][moveY] >= heights[x][y] && !canOcean[moveX][moveY]) {
                    queue.add(new int[]{moveX, moveY});
                    canOcean[moveX][moveY] = true;
                }
            }
        }
    }
}