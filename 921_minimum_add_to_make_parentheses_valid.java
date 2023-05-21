class Solution {
    // TC: O(n), SC: O(1)
    public int minAddToMakeValid(String s) {
        int ans = 0, bal = 0;
        for (int i = 0; i < s.length(); ++i) {
            bal += s.charAt(i) == ')' ? -1 : 1;
            if (bal < 0) {
                bal = 0;
                ans += 1;
            }
        }
        return ans + bal;
    }
}