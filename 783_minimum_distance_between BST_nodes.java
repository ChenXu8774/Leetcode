class Solution {
    Integer prev = null;
    int diff = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return diff;
    }
    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        diff = prev == null ? diff : Math.min(diff, Math.abs(prev - node.val));
        prev = node.val;
        helper(node.right);
    }
}