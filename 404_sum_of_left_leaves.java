class Solution {
    // TC: O(n), SC: O(h)
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        int res = 0;
        while (root.left != null) {
            res += sumOfLeftLeaves(root.right);
            root = root.left;
        }
        return res += root.right == null ? root.val : sumOfLeftLeaves(root.right);
    }
}