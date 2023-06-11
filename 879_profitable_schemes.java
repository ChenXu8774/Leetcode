class Solution {
    // TC: O(n * minProfit * m), SC: O(n * minProfit)
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        long[][] dp = new long[n + 1][minProfit + 1];
        dp[0][0] = 1;
        for (int i = 0; i < group.length; i++) {
            int labor = group[i];
            int prof = profit[i];
            for (int j = n - labor; j >= 0; j--) {
                for (int k = 0; k <= minProfit; k++) {
                    if (dp[j][k] == 0) {
                        continue;
                    }
                    int curProf = Math.min(k + prof, minProfit);
                    dp[j + labor][curProf] += dp[j][k];
                    dp[j + labor][curProf] %= 1000000007;
                    //System.out.println(Arrays.deepToString(dp));
                }
            }
        }
        long res = 0;
        for (int i = 0; i <= n; i++) {
            res = (res + dp[i][minProfit]) % 1000000007;
        }
        return (int) res;
    }
}