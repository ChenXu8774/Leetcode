class Solution {
    // TC: O(log(n)), SC: O(1)
    public int maximum69Number (int num) {
        int last6Ind = -1;
        int n = num;
        int digit = 0;
        while (n > 0) {
            if (n % 10 == 6) {
                last6Ind = digit;
            }
            n /= 10;
            digit++;
        }
        if (last6Ind == -1) {
            return num;
        }
        return num + (int) Math.pow(10, last6Ind) * 3;
    }
}
