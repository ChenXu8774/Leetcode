class Solution {
    // TC: O(n), SC: O(1)
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int pre = 0, cur = 1;
        while (n-- > 1) {
            int tmp = cur;
            cur = cur + pre;
            pre = tmp;
        }
        return cur;
    }
}