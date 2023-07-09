class Solution {
    // TC: O(n^2), SC: O(n)
    public int minimumBeautifulSubstrings(String s) {
        Set<String> powOfFive = new HashSet<>();
        powOfFive.add("1");
        powOfFive.add("101");
        powOfFive.add("1001110001");
        powOfFive.add("1111101");
        powOfFive.add("11001");
        powOfFive.add("110000110101");
        powOfFive.add("11110100001001");
        int res = -1;
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0') {
            return -1;
        }
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (powOfFive.contains(s.substring(0, i + 1))) {
                dp[i] = 1;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (powOfFive.contains(s.substring(j + 1, i + 1)) && dp[j] != 0) {
                    dp[i] = dp[i] == 0 ? dp[j] + 1 : Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[s.length() - 1] == 0 ? -1 : dp[s.length() - 1];
    }
}