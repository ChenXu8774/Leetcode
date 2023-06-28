class Solution {
    // TC: O(k * m * n), SC: O(m * k + n)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        helper(s, 0, dict, dp);
        return dp[0] == 1;
    }
    private int helper(String s, int ind, Set<String> dict, int[] dp) {
        if (ind == s.length()) {
            return 1;
        }
        if (dp[ind] != 0) {
            return dp[ind];
        }
        for (int i = ind; i < s.length(); i++) {
            if (dict.contains(s.substring(ind, i + 1))) {
                dp[ind] = helper(s, i + 1, dict, dp);
            }
            if (dp[ind] == 1) {
                break;
            } 
        }
        dp[ind] = dp[ind] == 1 ? 1 : -1;
        return dp[ind];
    }
}