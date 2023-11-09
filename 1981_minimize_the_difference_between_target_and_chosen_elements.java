class Solution {
    int res = Integer.MAX_VALUE;
    public int minimizeTheDifference(int[][] mat, int target) {
        Integer[][] dp = new Integer[mat.length][4901];
        helper(mat, 0, 0, target, dp);
        return res;
    }
    private int helper(int[][] mat, int ind, int sum, int target, Integer[][] dp) {
        if (ind == mat.length) {
            res = Math.min(Math.abs(sum - target), res);
            return Math.abs(sum - target);
        }
        if (dp[ind][sum] != null) return dp[ind][sum];
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < mat[0].length; i++) {
            ret = Math.min(ret, helper(mat, ind + 1, sum + mat[ind][i], target, dp));
        }
        dp[ind][sum] = ret;
        return ret;
    }
}