class Solution {
    public boolean isPerfectSquare(int num) {
        int res = 1;
        while (res <= num / res) {
            if ((double) res == (double) num / (double)res) {
                return true;
            }
            res++;
        }
        return false;
    }
}