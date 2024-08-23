class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = grid.length;
        if (grid[0][0] != 0 || grid[length-1][length-1] != 0) return -1;
        int path = 1;
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}, {-1,-1}, {1,1}, {-1,1}, {1,-1}};
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[length][length];

        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();
                int x = position[0];    
                int y = position[1];

                if (x == length-1 && y == length-1) 
                    return path;
                
                for (int j = 0; j < 8; j++) {
                    int moveX = x + directions[j][0];
                    int moveY = y + directions[j][1];

                    if (moveX < 0 || 
                    moveY < 0 || 
                    moveX >= length || 
                    moveY >= length ||
                    grid[moveX][moveY] != 0 ||
                    visited[moveX][moveY]) continue;

                    visited[moveX][moveY] = true;
                    queue.add(new int[]{moveX, moveY});
                }   
            }

            path++;
        } 
        
        return -1;
    }
}