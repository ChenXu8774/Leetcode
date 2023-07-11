class Solution {
    // TC: O(n), SC: O(1)
    public int longestSubarray(int[] nums) {
        int[] zeroInd = new int[]{-1, -1};
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            nums[i] += (i == 0 ? 0 : nums[i - 1]);
            if (val == 0) {
                zeroInd[0] = zeroInd[1];
                zeroInd[1] = i;
            }
            else {
                if (zeroInd[0] != -1) {
                    res = Math.max(res, nums[i] - nums[zeroInd[0]]);
                }
                else {
                    res = nums[i];
                }
            }
            
        }
        //System.out.println(Arrays.toString(zeroInd));
        return res == nums.length ? res - 1: res;
    }
}