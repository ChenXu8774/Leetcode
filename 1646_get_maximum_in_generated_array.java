class Solution {
    // TC: O(n), SC: O(n)
    public int getMaximumGenerated(int n) {
        if (n <= 1) {
             return n;
        }
        int res = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            }
            else {
                dp[i] = dp[i / 2] + dp[i / 2 + 1];
            }
            res = Math.max(res, dp[i]);
        }
        //System.out.println(Arrays.toString(dp));
        return res;
    }
}