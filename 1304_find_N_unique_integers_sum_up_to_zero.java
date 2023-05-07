class Solution {
    //TC: O(n), SC: O(1)
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int cur = 1;
        while (cur <= n / 2) {
            res[2 * (cur - 1)] = -cur;
            res[2 * (cur - 1) + 1] = cur;
            cur++;
        }
        if (n % 2 == 1) {
            res[n - 1] = 0;
        }
        return res;
    }
}