class Solution {
    // TC: O(n^2), SC: O(n^2)
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Boolean[][] dp = new Boolean[n][n + 1];
        return dfs(stones, 0, 0, dp);
    }
    private boolean dfs(int[] stones, int ind, int k, Boolean[][] dp) {
        if (ind == stones.length - 1) return true;
        if (dp[ind][k] != null) return dp[ind][k];
        dp[ind][k] = false;
        for (int i = Math.max(1, k - 1); i <= k + 1; i++) {
            int nxtInd = findInd(stones, stones[ind] + i);
            if (nxtInd != -1) dp[ind][k] |= dfs(stones, nxtInd, i, dp);
        }
        
        return dp[ind][k];
    }
    private int findInd(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) right = mid - 1;
            else if (arr[mid] < target) left = mid + 1;
            else return mid;
        }
        return -1;
    }
}