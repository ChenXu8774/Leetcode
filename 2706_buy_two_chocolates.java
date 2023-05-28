class Solution {
    // TC: O(n), SC: O(1)
    public int buyChoco(int[] prices, int money) {
        if (prices.length < 2) {
            return money;
        }
        int low1 = prices[0] <= prices[1] ? prices[0] : prices[1];
        int low2 = prices[0] <= prices[1] ? prices[1] : prices[0];
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] <= low1) {
                low2 = low1;
                low1 = prices[i];
            }
            else if (prices[i] < low2) {
                low2 = prices[i];
            }
        }
        return money >= low1 + low2 ? money - low1 - low2 : money;
    }
}