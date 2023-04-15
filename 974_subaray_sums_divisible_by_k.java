class Solution {
    // TC: O(n), SC: O(n)
    // When using prefix sum to solve the problem, remember to deal with the case of presum < 0 (when calculating the residual)
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> resCounter = new HashMap<>();
        resCounter.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i == 0? nums[i] % k : (nums[i] + nums[i - 1]) % k;
            if (nums[i] < 0) {
                nums[i] = nums[i] + k;
            }
            res += resCounter.getOrDefault(nums[i], 0);
            resCounter.put(nums[i], resCounter.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }
}