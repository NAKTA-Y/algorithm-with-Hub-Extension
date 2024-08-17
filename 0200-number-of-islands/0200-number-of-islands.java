class Solution {
    Deque<int[]> queue = new ArrayDeque<>();
    int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public int numIslands(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int count = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, h, w, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int x, int y, int h, int w, char[][] grid) {
        if (x < 0 || y < 0 || x >= h || y >= w || grid[x][y] != '1') return;

        grid[x][y] = '0';
        dfs(x+1, y, h, w, grid);
        dfs(x-1, y, h, w, grid);
        dfs(x, y+1, h, w, grid);
        dfs(x, y-1, h, w, grid);
    }
}