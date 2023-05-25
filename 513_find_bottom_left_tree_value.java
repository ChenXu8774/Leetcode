class Solution {
    // TC: O(n), SC: O(h)
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res.get(res.size() - 1);
    }
    private void helper(TreeNode node, List<Integer> res, int level) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(node.val);
        }
        helper(node.left, res, level + 1);
        helper(node.right, res, level + 1);
    }
}