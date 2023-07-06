class Solution {
    // TC: O(n^2), SC: O(n^2)
    public int longestArithSeqLength(int[] nums) {
        int res = 1;
        int[][] dp = new int[nums.length][1001];
        for (int[] arr : dp) {
            Arrays.fill(arr, 1);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + 500;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                res = Math.max(res, dp[i][diff]);
            }
        }
        return res;
    }
}