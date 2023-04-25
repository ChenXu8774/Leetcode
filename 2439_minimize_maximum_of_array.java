class Solution {
    // TC: O(n), SC: O(1)
    public int minimizeArrayValue(int[] nums) {
        int res = nums[0];
        long prefuxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefuxSum += nums[i];
            int curMax = (int) (prefuxSum % (i + 1) == 0 ? prefuxSum / (i + 1) : prefuxSum / (i + 1) + 1);
            if (curMax <= nums[i]) {
                res = Math.max(res, curMax);
            }         
        }
        return res;
    }
}