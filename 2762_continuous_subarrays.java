class Solution {
    // TC: O(n), SC: O(1)
    public long continuousSubarrays(int[] nums) {
        long res = 0;
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        int len = nums.length;
        int l = 0, r = 0;
        while (r < len) {
            cnt.put(nums[r], cnt.getOrDefault(nums[r], 0) + 1);
            while (cnt.lastKey() > 2 + cnt.firstKey() ) {
                res += (r - l);
                int val = nums[l];
                cnt.put(val, cnt.get(val) - 1);
                if (cnt.get(val) == 0) {
                    cnt.remove(val);
                }
                l++;
            }
            r++;
        }
        res = res + (long) (r - l + 1) * (long) (r - l) / 2;
        return res;
    }
}