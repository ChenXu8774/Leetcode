class Solution {
    // TC: O(n), SC:O(1)
    public void moveZeroes(int[] nums) {
        int curId = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[curId++] = nums[i];
            }
        }
        while (curId < nums.length) {
            nums[curId++] = 0;
        }
    }
}

