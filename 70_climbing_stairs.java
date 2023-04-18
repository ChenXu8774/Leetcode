class Solution {
    // TC: O(n), SC: O(1)
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int cur = 1;
        int pre = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = cur;
            cur = cur + pre;
            pre = tmp;
        }
        return cur;
    }
}