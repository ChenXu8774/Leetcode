class Solution {
    // TC: O(n), SC: O(1)
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > threshold || nums[i] % 2 == 1) {
                continue;
            }
            int left = i + 1;
            int mod = 1;
            while (left < nums.length && nums[left] <= threshold && nums[left] % 2 == mod) {
                left++;
                mod = 1 - mod;
            }
            res = Math.max(res, left - i);
            i = left - 1;
        }
        return res;
    }
}