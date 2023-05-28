class Solution {
    // TC: O(n^3), SC: O(n * max(len))
    public int minExtraChar(String s, String[] dictionary) {
        int len = s.length();
        Set<String> words = new HashSet<>();
        for (String word : dictionary) {
            words.add(word);
        }
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = i + 1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (words.contains(s.substring(j, i + 1))) {
                    if (j == 0) {
                        dp[i] = 0;
                        break;
                    }
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
            }
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[len - 1];
        
    }
}