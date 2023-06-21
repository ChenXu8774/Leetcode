class Solution {
    // TC: O(3^(n*m)), SC: O(m*n)
    int m, n, rem, res;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        rem = n * m;
        res = 0;
        int startRow = 0, startCol = 0;
        int endRow = 0, endCol = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
                else if (grid[i][j] == -1) {
                    rem--;
                }
                else if (grid[i][j] == 2) {
                    endRow = i;
                    endCol = j;
                }
            }
        }
        helper(grid, startRow, startCol, endRow, endCol);
        return res;
    }
    private void helper(int[][] grid, int curR, int curC, int er, int ec) {
        if (curR == er && curC == ec) {
            if (rem == 1) {
                res++;
            }
            return;
        }
        rem--;
        int val = grid[curR][curC];
        grid[curR][curC] = -1;
        for (int[] dir : dirs) {
            int nxtR = curR + dir[0], nxtC = curC + dir[1];
            if (Math.min(nxtR, nxtC) >= 0 && nxtR < m && nxtC < n && grid[nxtR][nxtC] != -1) {
                helper(grid, nxtR, nxtC, er, ec);
            }
        }
        rem++;
        grid[curR][curC] = val;
    }
}