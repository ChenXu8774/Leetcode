class Solution {
    // TC: O(n), SC: O(n)
    public int[] circularGameLosers(int n, int k) {
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            res[i - 1] = i;
        }
        res[0] = - res[0];
        int round = 1;
        int curInd = 0;
        while (true) {
            int nextInd = (k * round + curInd) % n;
            if (res[nextInd] < 0) {
                break;
            }
            res[nextInd] = -res[nextInd];
            curInd = nextInd;
            round++;
        }
        curInd = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 0) {
                res[curInd++] = i + 1;
            }
        }
        return Arrays.copyOfRange(res, 0, curInd);
    }
}