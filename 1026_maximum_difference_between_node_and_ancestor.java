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
    public int maxAncestorDiff(TreeNode root) {
        int[] res = new int[]{-1};
        helper(root, res);
        return res[0];
    }
    private int[] helper(TreeNode node, int[] res) {
        if (node.left == null && node.right == null) {
            return new int[]{node.val, node.val};
        }
        else if (node.left == null) {
            int[] range = helper(node.right, res);
            int diff = Math.max(Math.abs(node.val - range[0]), Math.abs(node.val - range[1]));
            res[0] = Math.max(diff, res[0]);
            range[0] = Math.min(range[0], node.val);
            range[1] = Math.max(range[1], node. val);
            return range;
        }
        else if (node.right == null) {
            int[] range = helper(node.left, res);
            int diff = Math.max(Math.abs(node.val - range[0]), Math.abs(node.val - range[1]));
            res[0] = Math.max(diff, res[0]);
            range[0] = Math.min(range[0], node.val);
            range[1] = Math.max(range[1], node. val);
            return range;
        }
        int[] rangeL = helper(node.left, res);
        int[] rangeR = helper(node.right, res);
        int[] range = new int[]{Math.min(rangeL[0], rangeR[0]), Math.max(rangeL[1], rangeR[1])};
        int diff = Math.max(Math.abs(node.val - range[0]), Math.abs(node.val - range[1]));
        res[0] = Math.max(diff, res[0]);
        range[0] = Math.min(range[0], node.val);
        range[1] = Math.max(range[1], node. val);
        return range;
    }
}
