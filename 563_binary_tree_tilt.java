class Solution {
    // TC: O(n), SC:O(h)
    int res = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        res += (Math.abs(left - right));
        return left + right + node.val;
    }
}