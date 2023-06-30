class Solution {
    // TC: O(n), SC: O(1)
    public int rob(int[] nums) {
        if (nums.length <= 2) {
            return Math.max(nums[0], nums[nums.length - 1]);
        }
        if (nums.length == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        int[] dp = new int[3];
        return Math.max(helper(nums, 0, dp), helper(nums, 1, dp));
    }
    private int helper(int[] nums, int startId, int[] dp) {
        dp[0] = nums[startId];
        dp[1] = nums[startId + 1];
        dp[2] = nums[startId] + nums[startId + 2];
        for (int i = startId + 3; i < nums.length - 1 + startId; i++) {
            int tmp = dp[2];
            dp[2] = Math.max(dp[0], dp[1]) + nums[i];
            dp[0] = dp[1];
            dp[1] = tmp;
        }
        return Math.max(dp[2], dp[1]);
    }
}