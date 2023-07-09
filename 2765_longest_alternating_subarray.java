class Solution {
    // TC: O(n), SC: O(1)
        public int alternatingSubarray(int[] nums) {
        int res = -1;
        int left = 0, right = 1;
        while (right < nums.length) {
            int diff = nums[right] - nums[left];
            while (right < nums.length && nums[right] - nums[left] != 1){
                right++;
                left++;
            }
            while (right < nums.length && nums[right] - nums[right - 1] == diff) {
                diff = diff * (-1);
                right++;
            }
            if (right - left >= 2) {
                res = Math.max(res, right - left);
            }
            left = right - 1;

        }
        return res;
    }
}