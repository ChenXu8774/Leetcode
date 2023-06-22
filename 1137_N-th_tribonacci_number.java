class Solution {
    // TC: O(n), SC: O(1)
    public int tribonacci(int n) {
        int[] dp = {0, 1, 1};
        if (n <= 2) {
            return dp[n];
        }
        while (n > 2) {
            int tmp = dp[2];
            dp[2] = dp[2] + dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = tmp;
            n--;
        }
        return dp[2];
    }
}