class Solution {
    // TC: O(n), SC: O(h)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }
    private void helper(TreeNode node, int level, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(node.val);
        }
        helper(node.right, level + 1, res);
        helper(node.left, level + 1, res);
    }
}