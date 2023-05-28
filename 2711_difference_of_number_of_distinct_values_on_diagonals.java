class Solution {
    // TC: O(n * m), SC: O(n * m)
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] topLeft = new int[m][n];
        int[][] botRigt = new int[m][n];
        Map<Integer, Set<Integer>> memo = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = i - j;
                if (memo.containsKey(val)) {
                    topLeft[i][j] = memo.get(val).size();
                }
                else {
                    topLeft[i][j] = 0;
                    memo.put(val, new HashSet<>());
                }
                memo.get(val).add(grid[i][j]);
            }
        }
        memo.clear();
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int val = i - j;
                if (memo.containsKey(val)) {
                    botRigt[i][j] = memo.get(val).size();
                }
                else {
                    botRigt[i][j] = 0;
                    memo.put(val, new HashSet<>());
                }
                memo.get(val).add(grid[i][j]);
                botRigt[i][j] = Math.abs(botRigt[i][j] - topLeft[i][j]);
            }
        }
        return botRigt;
    }
}