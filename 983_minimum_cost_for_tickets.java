class Solution {
    // TC: O(n), SC: O(n)
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        int ind = 0;
        for (int i = 1; i <= lastDay; i++) {
            if (i < days[ind]) {
                dp[i] = dp[i - 1];
                continue;
            }
            ind++;
            dp[i] = dp[i - 1] + costs[0];
            dp[i] = Math.min(dp[i], Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
        }
        return dp[lastDay];
    }
}