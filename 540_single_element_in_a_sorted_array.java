class Solution {
    // TC: O(n), SC: O(1)
    public int singleNonDuplicate(int[] nums) {
        int curInd = 0;
        while (curInd + 1 < nums.length && nums[curInd] == nums[curInd + 1]) {
            curInd += 2;
        }
        return nums[curInd];
    }
}