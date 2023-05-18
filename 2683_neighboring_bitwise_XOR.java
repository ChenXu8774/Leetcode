class Solution {
    // TC: O(n), SC: O(1)
    public boolean doesValidArrayExist(int[] derived) {
        if (derived.length == 1) {
            return derived[0] == 0;
        }
        int res = 0;
        for (int i = 0; i < derived.length; i++) {
            res ^= derived[i];
        }
        return res == 0;
    }
}