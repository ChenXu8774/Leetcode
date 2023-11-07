class Solution {
    // TC: O(n), SC: O(1)
    public int numOfSubarrays(int[] arr) {
        int[] count = new int[2];
        count[0] = 1;
        int sum = 0;
        int res = 0;
        int mod = 1000000007;
        for (int num : arr) {
            sum = (sum + num) % 2;
            res = (res + count[1 - sum]) % mod;
            count[sum]++;
        }
        return res;
    }
}