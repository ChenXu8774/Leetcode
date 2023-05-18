class Solution {
    // TC: O(nRow * 3^nCol), SC: O(nCol)
    int[] shift = new int[]{-1, 0, 1};
    public int maxMoves(int[][] grid) {
        int[] res = new int[]{0};
        for (int i = 0; i < grid.length; i++) {
            helper(grid, i, 0, grid[i][0], 0, res);
        }
        return res[0];
    }
    private void helper(int[][] grid, int row, int col, int preVal, int nMove, int[] res) {
        //System.out.println(preVal);
        if (res[0] == grid[0].length - 1) {
            return;
        }
        if (col + 1 == grid[0].length) {
            return;
        }
        
        for (int dR : shift) {
            int nR = dR + row;
            if (nR >= 0 && nR < grid.length && grid[nR][col + 1] > preVal) {
                helper(grid, nR, col + 1, grid[nR][col + 1], nMove + 1, res);
                res[0] = Math.max(res[0], nMove + 1);
            }
        }
    }
}