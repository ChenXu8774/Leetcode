class Solution {
    //TC: O(n), SC: O(1)
    public int rob(int[] nums) {
        if (nums.length <= 2) {
            return Math.max(nums[0], nums[nums.length - 1]);
        }
        int[] dp = new int[]{nums[0], nums[1], nums[0] + nums[2]};
        for (int i = 3; i < nums.length; i++) {
            int temp = dp[2];
            dp[2] = Math.max(dp[0], dp[1]) + nums[i];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return Math.max(dp[2], dp[1]);
    }
}