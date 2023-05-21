import java.util.Arrays;

public class i6_max_earning {
    public static void main(String[] args) {
        int[][] input = new int[][]{{85,411,121,449,819,38,420,237,523,467}, {382,952,319,880,938,675,993,609,123,702}};
        System.out.println(solution(input));
    }
    // TC: O(n), SC: O(1)
    private static int solution(int[][] earnings) {
        int[][] dp = new int[2][3];
        dp[0][0] = earnings[0][0];
        dp[1][0] = earnings[1][0];
        for (int i = 1; i < earnings[0].length; i++) {
            if (i == 1) {
                dp[0][1] = dp[0][0] + earnings[0][1];
                dp[1][1] = dp[1][0] + earnings[1][1];
                continue;
            }
            dp[0][2] = Math.max(dp[0][1] + earnings[0][i], dp[1][0] + earnings[0][i]);
            dp[1][2] = Math.max(dp[1][1] + earnings[1][i], dp[0][0] + earnings[1][i]);
            for (int j = 0; j < 2; j++) {
                dp[j][0] = dp[j][1];
                dp[j][1] = dp[j][2];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        int day = Math.min(2, earnings[0].length - 1);
        return Math.max(dp[0][day], dp[1][day]);
    }
}
