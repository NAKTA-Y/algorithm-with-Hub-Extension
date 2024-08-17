class Solution {
    Deque<int[]> queue = new ArrayDeque<>();
    int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public int numIslands(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visited[i][j] || grid[i][j] == '0') continue;
                visited[i][j] = true;
                queue.add(new int[] {i, j});
                bfs(h, w, grid, visited);
                count++;
            }
        }

        return count;
    }

    public void bfs(int h, int w, char[][] grid, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int moveX = x + directions[i][0];
                int moveY = y + directions[i][1];

                if (moveX < 0 || moveY < 0 || moveX >= h || moveY >= w || grid[moveX][moveY] != '1' || visited[moveX][moveY]) {
                    continue;
                }

                queue.add(new int[] {moveX, moveY});
                visited[moveX][moveY] = true;
            }
        }
    }
}