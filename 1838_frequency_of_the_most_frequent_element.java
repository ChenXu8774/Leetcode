class Solution {
    // TC: O(n), SC: O(1)
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        int freq = 1, left = 0, nOp = 0;
        for (int i = 1; i < nums.length; i++) {
            nOp = nOp + (nums[i] - nums[i - 1]) * (i - left);
            while (nOp > k) {
                nOp = nOp - (nums[i] - nums[left]);
                left++;
            }
                
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}