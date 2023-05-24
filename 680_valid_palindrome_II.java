class Solution {
    // TC: O(n), SC: O(n)
    public boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1, 1);
    }
    private boolean helper(String s, int l, int r, int k) {
        if (l >= r) {
            return true;
        }
        if (s.charAt(l) != s.charAt(r)) {
            if (k == 0) {
                return false;
            }
            return helper(s, l + 1, r, k - 1) || helper(s, l, r - 1, k - 1);
        }
        return helper(s, l + 1, r - 1, k);
    }
}