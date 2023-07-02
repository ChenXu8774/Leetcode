/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // TC: O(n), SC: O(h)
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return res[1];
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int left[] = helper(node.left);
        int right[] = helper(node.right);
        int ret = Math.max(left[1] + right[1], left[0] + right[0] + node.val);
        return new int[]{left[1] + right[1], ret};
    }
}