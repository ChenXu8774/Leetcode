class Solution {
    // TC: O(nlogn + mlogn), SC: O(n)
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            queries[i] = findInd(nums, queries[i]);
        }
        return queries;
    }
    private int findInd(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        return left + 1;
    }
}
