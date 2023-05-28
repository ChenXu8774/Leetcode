class Solution {
    // TC: O(n), SC: O(1)
    public long minimumCost(String s) {
        long res = 0;
        int len = s.length();
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                res += Math.min(len - i, i);
            }
        }
        return res;
    }
}