class Solution {
    public boolean divisorGame(int n) {
        if (n == 1) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            int j = 1;
            while (j < i && dp[i] == false) {
                if (i % j == 0) {
                    dp[i] = !dp[i - j];
                }
                j++;
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}