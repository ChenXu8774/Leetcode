class Solution {
    // TC: O(log(100000) * n + k ^ 2), SC: O(k)
    public long countPairs(int[] nums, int k) {
        Map<Long, Long> cnt = new HashMap<>();
        for (int num : nums) {
            long val = gcd(k, num);
            cnt.put(val, cnt.getOrDefault(val, 0L) + 1);
        }
        long res = 0;
        for (long k1 : cnt.keySet()) {
            for (long k2 : cnt.keySet()) {
                if (k1 <= k2 && (k1 * k2) % k == 0L) {
                    res += k1 == k2 ? cnt.get(k1) * (cnt.get(k2) - 1L) / 2L : cnt.get(k1) * cnt.get(k2);
                }
            }
        }
        return res;
    }
    private long gcd(int a1, int a2) {
        if (a1 < a2) {
            gcd(a2, a1);
        }
        return a2 == 0 ? a1 : gcd(a2, a1 % a2);
    }
}