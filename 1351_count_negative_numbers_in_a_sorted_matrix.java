class Solution {
    // TC: O(m + n), SC: O(1)
    public int countNegatives(int[][] grid) {
        int r = grid.length - 1;
        int c = 0;
        int res = 0;
        while (r >= 0 && c < grid[0].length) {
            if (grid[r][c] < 0) {
                res += (grid[0].length - c);
                r--;
            }
            else {
                c++;
            }
        }
        return res;
    }
}