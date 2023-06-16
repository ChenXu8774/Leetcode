class Solution {
    // TC: O(l1*l2), SC: O(l1*l2)
    public boolean isSubsequence(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = i; j <= l2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[l1][l2];
    }
}