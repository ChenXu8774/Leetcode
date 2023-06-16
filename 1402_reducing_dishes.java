class Solution {
    // TC: O(n), SC: O(n)
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        //System.out.println(Arrays.toString(satisfaction));
        int curSum = 0;
        int len = satisfaction.length;
        int[] prefixSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = prefixSum[i] + satisfaction[i];
            curSum += (i + 1) * satisfaction[i];
        }
        int res = Math.max(curSum, 0);
        for (int i = 0; i < len; i++) {
            if (satisfaction[i] >= 0) {
                break;
            }
            curSum = curSum - (prefixSum[len] - prefixSum[i]);
            res = Math.max(res, curSum);
        }
        return res;
    }
}