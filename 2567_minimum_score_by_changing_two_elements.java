class Solution {
    // TC: O(nlogn), SC: O(n)
    public int minimizeSum(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        return Math.min(nums[l - 1] - nums[2], Math.min(nums[l - 3] - nums[0], nums[l - 2] - nums[1]));
    }
}