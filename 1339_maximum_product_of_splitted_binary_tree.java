//1339. Maximum Product of Splitted Binary Tree

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
    // TC: O(n), SC: O(n)
    public int maxProduct(TreeNode root) {
        long totalSum = getSum(root);
        long[] res = {0};
        getProd(root, res, totalSum);
        return (int)(res[0]  % 1000000007);
    }
    private long getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return ((long)getSum(node.left) + (long)getSum(node.right) + (long)node.val);
    }
    private long getProd(TreeNode node, long[] res, long total) {
        if (node == null) {
            return 0;
        }
        long subSum = getProd(node.left, res, total) + getProd(node.right, res, total) + node.val;
        res[0] = Math.max(res[0], (total - subSum) * subSum);
        return subSum;
    }
}