class Solution {
    // TC: O(n * k), SC: O(n * k)
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        for (int[] line : dp) {
            Arrays.fill(line, -1);
        }
        helper(piles, n, k, dp);
        //System.out.println(Arrays.deepToString(dp));
        return dp[n][k];
    }
    private int helper(List<List<Integer>> piles, int ind, int k, int[][] dp) {
        if (ind == 0 || k == 0) {
            return 0;
        }
        if (dp[ind][k] >= 0) {
            return dp[ind][k];
        }
        dp[ind][k] = 0;
        int sum = 0;
        for (int i = 0; i <= Math.min(k, piles.get(ind - 1).size()); i++) {
            sum += i == 0 ? 0 : piles.get(ind - 1).get(i - 1);
            dp[ind][k] = Math.max(helper(piles, ind - 1, k - i, dp) + sum, dp[ind][k]);
        }
        return dp[ind][k];
    }
}
