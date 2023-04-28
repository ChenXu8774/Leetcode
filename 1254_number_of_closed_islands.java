class Solution {
    // TC: O(n*m), SC: O(min(m, n))
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int rows;
    int cols;
    public int closedIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 1 && grid[rows - 1][i] == 1) {
                continue;
            }
            if (grid[0][i] == 0) {
                updateGrid(grid, 0, i);
            }
            if (grid[rows - 1][i] == 0) {
                updateGrid(grid, rows - 1, i);
            }
        }
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1 && grid[i][cols - 1] == 1) {
                continue;
            }
            if (grid[i][0] == 0) {
                updateGrid(grid, i, 0);
            }
            if (grid[i][cols - 1] == 0) {
                updateGrid(grid, i, cols - 1);
            }
        }
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    updateGrid(grid, i, j);
                }
            }
        }
        return res;
    }
    private void updateGrid(int[][] grid, int j, int i) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{j, i});
        grid[j][i] = 1;
        while(!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int r = cur[0];
            int c = cur[1];
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (Math.min(nr, nc) >= 0 && nr < rows && nc < cols && grid[nr][nc] == 0) {
                    q.offerLast(new int[]{nr, nc});
                    grid[nr][nc] = 1;
                }
            }
        }
    }
}
