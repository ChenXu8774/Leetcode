class Solution {
    // TC: O(k ^ n), SC: (k + n)
    int res = Integer.MAX_VALUE;
    int k;
    public int distributeCookies(int[] cookies, int k) {
        this.k = k;
        int[] sum = new int[k];
        helper(cookies, 0, sum, k);
        return res;
    }
    private void helper(int[] cookies, int indC, int[] sum, int zeroCount) {
        
        if (indC == cookies.length) {
            int maxVal = 0;
            for (int val : sum) {
                maxVal = Math.max(val, maxVal);
            }
            res = Math.min(res, maxVal);
            return;
        }
        if (zeroCount > cookies.length - indC) {
            return;
        }
        
        for (int i = 0; i < k; i++) {
            zeroCount = sum[i] == 0 ? zeroCount - 1 : zeroCount;
            sum[i] += cookies[indC];
            helper(cookies, indC + 1, sum, zeroCount);
            sum[i] -= cookies[indC];
            zeroCount = sum[i] == 0 ? zeroCount + 1 : zeroCount;
        }
        
    }
}