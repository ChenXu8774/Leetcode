class Solution {
    // TC: O(n^2), SC: O(n^2)
    public boolean isValidPalindrome(String s, int k) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        isValidPalindrome(s, 0, s.length() - 1, memo);
        return memo[0][s.length() - 1] <= k;
    }
    private int isValidPalindrome(String s, int i, int j, Integer[][] memo) {
        if (i == j) {
            memo[i][j] = 0;
            return 0;
        }
        if (i == j - 1) {
            memo[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
            return memo[i][j]; 
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = isValidPalindrome(s, i + 1, j - 1, memo);
        }
        else {
            memo[i][j] = 1 + Math.min(isValidPalindrome(s, i + 1, j, memo), isValidPalindrome(s, i, j - 1, memo));
        }
        return memo[i][j];
    }
}