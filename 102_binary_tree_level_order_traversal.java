class Solution {
    // TC: O(n), SC: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode cur = q.pollFirst();
                level.add(cur.val);
                if (cur.left != null) {
                    q.offerLast(cur.left);
                }
                if (cur.right != null) {
                    q.offerLast(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}