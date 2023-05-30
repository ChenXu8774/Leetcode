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
    List<Integer> res = new ArrayList<>();
    int curMaxCnt = 0;
    int prev = Integer.MIN_VALUE;
    int curCnt = 0;
    public int[] findMode(TreeNode root) {
        helper(root);
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        if (prev == node.val) {
            curCnt++;
        }
        else {
            curCnt = 1;
        }
        if (curCnt == curMaxCnt) {
            res.add(node.val);
        }
        else if (curCnt > curMaxCnt) {
            curMaxCnt = curCnt;
            res.clear();
            res.add(node.val);
        }
        prev = node.val;
        helper(node.right);
    }
}