class Solution {
    // TC: O(log(n)*log(n)), SC: O(1)
    public int trailingZeroes(int n) {
        int res = 0;
        int div = 5;
        while (n / div >= 1) {
            res += n / div;
            div *= 5;
        }
        return res;
    }
}
