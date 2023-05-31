class Solution {
    // TC: O(mn), SC: O(mn)
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int rows, cols;
    public int islandPerimeter(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                res = helper(grid, i, j, visited);
            }
        }
        return res;
    }
    private int helper(int[][] grid, int i, int j, boolean[][] visited) {
        int res = 4;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int nxtR = i + dir[0];
            int nxtC = j + dir[1];
            if (Math.min(nxtR, nxtC) >= 0 && nxtR < rows && nxtC < cols && grid[nxtR][nxtC] == 1) {
                res--;
                if (!visited[nxtR][nxtC]) {
                    res += helper(grid, nxtR, nxtC, visited);
                }    
            }
        }
        return res;
    }
}