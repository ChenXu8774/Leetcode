class Solution {
    // TC: O(m * n), SC: O(m * n)
    int m, n;
    public int[] findBall(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -2);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = helper(grid, 0, i, dp);
        }
        System.out.println(Arrays.deepToString(dp));
        return res;
    }
    private int helper(int[][] grid, int r, int c, int[][] dp) {
        if(r == m) {
            return c;
        }
        if (dp[r][c] != -2) {
            return dp[r][c];
        }
        int slope = grid[r][c];
        if (slope == 1) {
            if (c == n - 1 || grid[r][c + 1] == -1) {
                dp[r][c] = -1;
            }
            else {
                dp[r][c] = helper(grid, r + 1, c + 1, dp);
            }
        }
        else {
            if (c == 0 || grid[r][c - 1] == 1) {
                dp[r][c] = -1;
            }
            else {
                dp[r][c] = helper(grid, r + 1, c - 1, dp);
            }
        }
        return dp[r][c];
    }
}