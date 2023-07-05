class Solution {
    // TC: O(n ^2), SC: O(1)
    int n;
    public int maxDistance(int[][] grid) {
        n = grid.length;
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    continue;
                }
                grid[i][j] = 2 * n + 1;
                grid[i][j] = Math.min(grid[i][j], 
                Math.min(i > 0 ? grid[i - 1][j] + 1: 2 * n + 1, 
                         j > 0 ? grid[i][j - 1] + 1: 2 * n + 1));
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                grid[i][j] = Math.min(grid[i][j], 
                Math.min(i < n - 1 ? grid[i + 1][j] + 1: 2 * n + 1, 
                         j < n - 1 ? grid[i][j + 1] + 1: 2 * n + 1));
                res = Math.max(res, grid[i][j]);
            }
        }
        return res == 0 || res == 2 * n + 1 ? -1 : res;
    }

}