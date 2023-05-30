class Solution {
    // TC: O(n^2), SC: O(n^2)
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                cnt.put(n1 + n2, cnt.getOrDefault(n1 + n2, 0) + 1);
            }
        }
        int res = 0;
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                res += cnt.getOrDefault(-(n3 + n4), 0);
            }
        }
        return res;
    }
}