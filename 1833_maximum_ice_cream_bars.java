class Solution {
    // TC: O(nlogn), SC: O(n)
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        while (res < costs.length && coins >= costs[res]) {
            coins = coins - costs[res++];
        }
        return res;
    }
}