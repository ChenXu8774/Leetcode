class Solution {
    // TC: O(n^2), SC: O(n)
    public int sumImbalanceNumbers(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            Set<Integer> s = new HashSet<>();
            s.add(nums[i]);
            int cur = 0;
            for (int j = i + 1; j < n; ++j) {
                if (!s.contains(nums[j])) {
                    int d = 1;
                    if (s.contains(nums[j] - 1)) d--;
                    if (s.contains(nums[j] + 1)) d--;
                    cur += d;
                    s.add(nums[j]);
                }
                res += cur;
            }
        }
        return res;
    }
}