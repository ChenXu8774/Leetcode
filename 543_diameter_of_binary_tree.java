class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[]{0};
        helper(root, res);
        return res[0];
    }
    // TC: O(n), SC: O(h)
    private int helper(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }
        int leftH = helper(node.left, res);
        int rightH = helper(node.right, res);
        res[0] = Math.max(res[0], leftH + rightH);
        return Math.max(leftH, rightH) + 1;
    }
}