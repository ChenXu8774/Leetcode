class Solution {
    // TC: O(log(n)), SC: O(1)
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int sign = x / Math.abs(x);
        x = Math.abs(x);
        int res = 0;
        int nDigit = 0;
        while (x > 0) {
            if (nDigit == 9 ) {
                if (sign > 0 && res > (double)(Integer.MAX_VALUE - x % 10) / 10) {
                    return 0;
                }
                if (sign < 0 && res > (double)(Integer.MAX_VALUE - x % 10 + 1) / 10) {
                    return 0;
                }
            }
            res = res * 10 + x % 10;
            x = x / 10;
            nDigit++;
        } 
        return sign * res;
    }
}