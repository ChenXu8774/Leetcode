class Solution {
    // TC: O(n), SC: O(1)
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int res = 0;
        while (left < nums.length - 1) {
            int diff = nums[left + 1] - nums[left];
            while (right + 1 < nums.length && nums[right + 1] - nums[right] == diff) {
                res += (right - left);
                right++;
            }
            left = right;
            right++;
        }
        return res;
    }
}