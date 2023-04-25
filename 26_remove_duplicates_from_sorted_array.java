class Solution {
    // TC: O(n), SC: O(1)
    public int removeDuplicates(int[] nums) {
        int ind = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[ind++] = nums[i];
            }
        }
        return ind;
    }
}