class Solution {
    //TC: O(M*N), SC: O(M*N)
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                Deque<int[]> blocks = new ArrayDeque<>();
                blocks.offerLast(new int[]{i, j});
                grid[i][j] = '0';
                while (!blocks.isEmpty()) {
                    int[] cur = blocks.pollFirst();
                    int row = cur[0];
                    int col = cur[1];
                    for (int[] dir : dirs) {
                        int nextRow = row + dir[0];
                        int nextCol = col + dir[1];
                        if (Math.min(nextRow, nextCol) >= 0 && nextRow < rows && nextCol < cols && grid[nextRow][nextCol] == '1') {
                            blocks.offerLast(new int[]{nextRow, nextCol});
                            grid[nextRow][nextCol] = '0';
                        } 
                    }
                }
                res++;
            }
        }
        return res;
    }
}