class Solution {
    // TC: O(n), SC: O(1)
    public int findLengthOfLCIS(int[] nums) {
        int dp = 1, res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp++;
                if (dp > res) {
                    res = dp;
                }
            }
            else {
                dp = 1;
            }
        }
        return res;
    }
}