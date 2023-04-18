class Solution {
    // TC: O(1), SC:O(1)
    public int countOdds(int low, int high) {
        int res = (high - low) / 2;
        if (low % 2 == 1 || high % 2 == 1) {
            res++;
        }
        return res;
    }
}