class Solution {
    // TC: O(2 ^ n), SC: O(n)
    public List<String> generateParenthesis(int n) {
        StringBuilder cur = new StringBuilder();
        List<String> res = new ArrayList<>();
        helper(cur, n, n, res);
        return res;
    }
    private void helper(StringBuilder cur, int l, int r, List<String> res) {
        if (l == 0 && r == 0) {
            res.add(cur.toString());
            return;
        }
        if (l > 0) {
            cur.append('(');
            helper(cur, l - 1, r, res);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (r > l) {
            cur.append(')');
            helper(cur, l, r - 1, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}