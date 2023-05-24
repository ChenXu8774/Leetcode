class Solution {
    // TC: O(n*m), SC: O(min(n, m))
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        if (grid[0][0] != 0) {
            return -1;
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{0, 0});
        grid[0][0] = 1;
        int res = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.pollFirst();
                int r = cur[0], c = cur[1];
                if (r == grid.length - 1 && c == grid[0].length - 1) {
                    return res;
                }
                for (int[] dir : dirs) {
                    int nR = r + dir[0], nC = c + dir[1];
                    if(Math.min(nR, nC) >= 0 && nR < grid.length && nC < grid[0].length && grid[nR][nC] == 0) {
                        q.offerLast(new int[]{nR, nC});
                        grid[nR][nC] = 1;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}