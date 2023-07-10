class Solution {
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(nums[i] - nums[j]) > target || dp[j] == Integer.MIN_VALUE) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return dp[nums.length - 1] == Integer.MIN_VALUE ? -1 : dp[nums.length - 1];
    }
}