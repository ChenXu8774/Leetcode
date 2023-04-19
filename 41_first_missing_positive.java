class Solution {
    // TC: O(n), SC: O(1)
    public int firstMissingPositive(int[] nums) {
        boolean hasOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                hasOne = true;
                break;
            }
        }
        if (!hasOne) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 1 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] > 0)
                nums[val - 1] = -nums[val - 1];
        }
        //System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }
}