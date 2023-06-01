class Solution {
    // TC: O(n), SC: O(1)
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        helper(n, 0, res);
        return res;
    }
    private void helper(int n, int digit, List<Integer> res) {
        for (int i = digit; i <= digit + 9; i++) {
            if (i > n) {
                return;
            }
            if (i > 0) {
                res.add(i);
                helper(n, 10 * i, res);
            }   
        }
    }
}