class Solution {
    public int[] sortArray(int[] nums) {
        int[] buffer = new int[nums.length];
        helper(nums, 0, nums.length - 1, buffer);
        return nums;
    }
    private void helper(int[] nums, int left, int right, int[] buffer) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        helper(nums, left, mid, buffer);
        helper(nums, mid + 1, right, buffer);
        merge(nums, left, right, buffer);
    }
    private void merge(int[] nums, int left, int right, int[] buffer) {
        int mid = left + (right - left) / 2;
        for (int i = left; i <= right; i++) {
            buffer[i] = nums[i];
        }
        int id1 = left;
        int id2 = mid + 1;
        int id = left;
        while (id <= right) {
            if (id1 > mid) {
                nums[id++] = buffer[id2++];
            }
            else if (id2 > right) {
                nums[id++] = buffer[id1++];
            }
            else {
                if (buffer[id1] < buffer[id2]) {
                    nums[id++] = buffer[id1++];
                }
                else {
                    nums[id++] = buffer[id2++];
                }
            }
        }
    }
}