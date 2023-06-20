class Solution {
    // TC: O(n), SC: O(1)
    public int minCostClimbingStairs(int[] cost) {
        int ind = 2, pre = cost[0], cur = cost[1];
        while (ind < cost.length) {
            int temp = cur;
            cur = Math.min(pre, cur) + cost[ind++];
            pre = temp;
        }
        return Math.min(pre, cur);
    }
}