class Solution {
    // TC: O(n), SC: O(1)
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = curSum >= 0 ? nums[i] + curSum : nums[i];
            res = Math.max(res, curSum);
        }
        return res;
    }
}