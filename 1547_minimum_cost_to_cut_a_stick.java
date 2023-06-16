class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        long[][] memo = new long[cuts.length][cuts.length];
        for (int i = 0; i < cuts.length; i++) {
            for (int j = 0; j < cuts.length; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
        helper(0, n, cuts, 0, cuts.length - 1, memo);
        //System.out.println(Arrays.deepToString(memo));
        return (int)memo[0][cuts.length - 1];
    }

    private long helper(int left, int right, int[] cuts, int leftInd, int rightInd, long[][] memo) {
        if (leftInd == rightInd) {
            memo[leftInd][rightInd] = right - left;
            return right - left;
        }
        if (leftInd > rightInd) {
            return 0;
        }
        if (memo[leftInd][rightInd] != Integer.MAX_VALUE) {
            return memo[leftInd][rightInd];
        }
        for (int i = leftInd ; i <= rightInd; i++) {
            long cost = helper(left, cuts[i], cuts, leftInd, i - 1, memo) + helper(cuts[i], right, cuts, i + 1, rightInd, memo) + right - left;
            memo[leftInd][rightInd] = Math.min(memo[leftInd][rightInd], cost);
        }
        return memo[leftInd][rightInd];
    }
}