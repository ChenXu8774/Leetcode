class Solution {
    // TC: O(n), SC:O(h)
    int res = 0;
    public int diameter(Node root) {
        helper(root);
        return res;
    }
    private int helper(Node root) {
        if (root == null) {
            return 0;
        }
        int n1 = 0;
        int n2 = 0;
        for (Node node : root.children) {
            int curN = helper(node);
            if (curN >= n2) {
                n1 = n2;
                n2 = curN;
            }
            else if (curN > n1){
                n1 = curN;
            }
        }
        res = Math.max(res, n1 + n2);
        return Math.max(n1, n2) + 1;
    }
}