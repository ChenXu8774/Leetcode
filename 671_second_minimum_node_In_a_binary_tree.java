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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Integer[] holder = new Integer[2];
        helper(root, holder);
        if (holder[1] == null) {
            return -1;
        }
        return holder[1];
    }
    private void helper(TreeNode node, Integer[] holder) {
        if (node == null) {
            return;
        }
        
        if (holder[0] == null) {
            holder[0] = node.val;
        }
        else if (node.val == holder[0]) {
            holder[0] = node.val;
        }
        else if (node.val < holder[0]) {
            holder[1] = holder[1];
            holder[0] = node.val; 
        }
        else if (holder[1] == null || holder[1] > node.val) {
            holder[1] = node.val;
        }
        //System.out.println(Arrays.toString(holder));
        helper(node.left, holder);
        helper(node.right, holder);
    }
}