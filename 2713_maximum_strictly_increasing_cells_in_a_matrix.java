class Solution {

    //TC: O(mn*log(mn)), SC: O(mn)
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m + n];
        int[][] dp = new int[m][n];
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = mat[i][j];
                if (!map.containsKey(val)) {
                    map.put(val, new ArrayList<>());
                }
                map.get(val).add(new int[]{i, j});
            }
        }
        for (int key : map.keySet()) {
            for (int[] cur : map.get(key)) {
                int r = cur[0], c = cur[1];
                dp[r][c] = Math.max(res[r], res[m + c]) + 1;
            }
            for (int[] cur : map.get(key)) {
                int r = cur[0], c = cur[1];
                res[r] = Math.max(res[r], dp[r][c]);
                res[m + c] = Math.max(res[m + c], dp[r][c]);
            }
        }
        int ans = 0;
        for (int val : res) {
            ans = Math.max(ans, val);
        }
        return ans;
    }
}