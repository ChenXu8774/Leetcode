class Solution {
    // TC: O(n), SC: O(1)
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long expr = expressCost;
        long regr = 0;
        long[] res = new long[regular.length];
        for (int i = 0; i < regular.length; i++) {
            long tmp = regr;
            tmp = Math.min(regr + regular[i], expr + express[i]);
            expr = Math.min(regr + regular[i] + expressCost, expr + express[i]);
            regr = tmp;
            res[i] = Math.min(regr, expr);
        }
        return res;
    }
}