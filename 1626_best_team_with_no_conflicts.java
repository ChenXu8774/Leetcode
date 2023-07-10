class Solution {
    // TC: O(n^2), SC: O(n)
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] info = new int[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            info[i][0] = ages[i];
            info[i][1] = scores[i];
        }
        Arrays.sort(info, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[ages.length];
        dp[0] = info[0][1];
        int res = info[0][1];
        for (int i = 1; i < ages.length; i++) {
            dp[i] = info[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (info[i][0] == info[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + info[i][1]);
                }
                else {
                    if (info[i][1] >= info[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + info[i][1]);
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}