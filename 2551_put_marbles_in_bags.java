class Solution {
    //TC: O(nlogn), SC: O(n)
    public long putMarbles(int[] weights, int k) {
        long[] pairSum = new long[weights.length - 1];
        int len = weights.length;
        for (int i = 1; i < len; i++) {
            pairSum[i - 1] = weights[i - 1] + weights[i]; 
        }
        Arrays.sort(pairSum);
        long res = 0;
        for (int i = 0; i < k - 1; i++) {
            res += (pairSum[len - 2 - i] - pairSum[i]);
        }
        return res;
    }
}