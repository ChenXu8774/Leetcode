//1672. Richest Customer Wealth

class Solution {
    //TC: O(n*m), SC: O(1)
    public int maximumWealth(int[][] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 1; j < accounts[0].length; j++) {
                accounts[i][j] += accounts[i][j - 1];
            }
            if (i >= 1) {
                accounts[i][accounts[0].length - 1] = Math.max(accounts[i][accounts[0].length - 1], accounts[i - 1][accounts[0].length - 1]);
            }
            
        }
        return accounts[accounts.length - 1][accounts[0].length - 1];
    }
}