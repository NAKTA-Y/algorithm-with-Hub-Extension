class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        Deque<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int minute = -1;
        int remainFresh = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    remainFresh++;
                }
            }
        }

        if (queue.isEmpty() && remainFresh == 0) return 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();
                int x = position[0];
                int y = position[1];

                for (int j = 0; j < 4; j++) {
                    int moveX = x + directions[j][0];
                    int moveY = y + directions[j][1];

                    if (moveX < 0 || moveY < 0 || moveX >= m || moveY >= n || grid[moveX][moveY] != 1) {
                        continue;
                    }

                    grid[moveX][moveY] = 2;
                    queue.add(new int[]{moveX, moveY});
                    remainFresh--;
                }
            }

            minute++;
        }

        return remainFresh == 0 ? minute : -1;
    }
}