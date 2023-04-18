class Solution {
    // TC: O(n), SC: O(1)
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        if (minK > maxK) {
            return res;
        }
        int leftBound = -1;
        int posMax = -1;
        int posMin = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftBound = i;
            }
            if (nums[i] == minK) {
                posMin = i;
            }
            if (nums[i] == maxK) {
                posMax = i;
            }
            if (posMin >= leftBound && posMax >= leftBound) {
                res = res + Math.min(posMax, posMin) - leftBound;
            }
        }
        return res;
    }
}