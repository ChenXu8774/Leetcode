class Solution {
    // TC: O(log(n)), SC: O(1)
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int copy = n;
        int mask = 1;
        while (copy > 0) {
            n = n ^ mask;
            mask = mask << 1;
            copy = copy >> 1;
        }
        return n;
    }
}