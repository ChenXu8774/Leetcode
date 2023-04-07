class Solution {
    // SC: O(1), TC: O(n)
    public int maxProfit(int[] prices) {
        int res = 0;
        int curMin = prices[0];
        for (int price : prices) {
            curMin = Math.min(curMin, price);
            res = Math.max(res, price - curMin);
        }
        return res;
    }
}