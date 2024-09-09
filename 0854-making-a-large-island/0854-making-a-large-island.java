class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int areaNum = 2;
        int max = 1;
        Map<Integer, Integer> areaMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = floodFill(i, j, n, areaNum, grid);
                    areaMap.put(areaNum, area);
                    areaNum++;
                    max = Math.max(max, area);
                }
            }
        }

        Set<Integer> connectSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int sum = 1;
                    connectSet.add(i == 0 ? 0 : grid[i-1][j]);
                    connectSet.add(i == (n-1) ? 0 : grid[i+1][j]);
                    connectSet.add(j == 0 ? 0 : grid[i][j-1]);
                    connectSet.add(j == (n-1) ? 0 : grid[i][j+1]);

                    for (Integer connectArea : connectSet) {
                        sum += areaMap.getOrDefault(connectArea, 0);
                    }

                    max = Math.max(max, sum);
                    connectSet.clear();
                }
            }
        }

        return max;
    }

    private int floodFill(int i, int j, int n, int areaNum, int[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return 0;
        grid[i][j] = areaNum;

        int sum = 1;
        sum += floodFill(i+1, j, n, areaNum, grid);
        sum += floodFill(i, j+1, n, areaNum, grid);
        sum += floodFill(i-1, j, n, areaNum, grid);
        sum += floodFill(i, j-1, n, areaNum, grid);

        return sum;
    }
}