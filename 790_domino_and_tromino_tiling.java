class Solution {
    // TC: O(n), SC: O(n)
    public int numTilings(int n) {
        long mod = 1000000007;
        long res = 0;
        if (n == 1) {
            return 1;
        }
        long[] dp0 = new long[n + 1];
        long[] dp1 = new long[n + 1];
        dp0[1] = 1;
        dp0[0] = 1;
        for (int i = 2; i <= n; i++) {
            dp0[i] = (dp0[i - 1] + dp1[i - 1] + dp0[i - 2]) % mod;
            dp1[i] = (dp0[i - 2] * 2 + dp1[i - 1]) % mod;
        }
        return (int) dp0[n];
    }
}