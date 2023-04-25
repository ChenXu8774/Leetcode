class Solution {
    // TC: O(k * n * m * (m + n)), SC: O(k * n * m)
    public int ways(String[] pizza, int k) {
        int rows = pizza.length;
        int cols = pizza[0].length();
        int[][] prefixSum = new int[rows + 1][cols + 1];
        int[][][] dp = new int[rows][cols][k];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                char ch = pizza[i].charAt(j);
                prefixSum[i][j] = prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i + 1][j + 1];
                if (ch == 'A') {
                    prefixSum[i][j]++;
                }
            }
        }
        if (k == 1) {
            return prefixSum[0][0] > 0 ? 1 : 0;
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (prefixSum[i][j] > 0) {
                    dp[i][j][0] = 1;
                }
            }
        }
        for (int cut = 1; cut < k; cut++) {
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 0; j--) {
                    for (int h = i + 1; h < rows; h++) {
                        if (prefixSum[i][j] - prefixSum[h][j] > 0) {
                            dp[i][j][cut] += dp[h][j][cut - 1];
                            dp[i][j][cut] %= 1000000007; 
                        }
                    }
                    for (int v = j + 1; v < cols; v++) {
                        if (prefixSum[i][j] - prefixSum[i][v] > 0) {
                            dp[i][j][cut] += dp[i][v][cut - 1];
                            dp[i][j][cut] %= 1000000007; 
                        }
                    }
                }
            }
        }
        return dp[0][0][k - 1];
    }
}