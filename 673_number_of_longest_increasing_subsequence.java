class Solution {
    // TC: O(n^2), SC: O(n)
    public int findNumberOfLIS(int[] nums) {
        int res = 1;
        int maxL = 1;
        int[][] dp = new int[nums.length][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, 1);
        }
        //System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if(dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    }
                    else if (dp[j][0] + 1 == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    }
                }
            }
            if (maxL == dp[i][0]) {
                res += dp[i][1];
            }
            else if (maxL < dp[i][0]) {
                maxL = dp[i][0];
                res = dp[i][1];
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return res;
    }
}