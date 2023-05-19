class Solution {
    // TC: O(n), SC: O(log(n))
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res = helper(nums, 0, nums.length - 1);
        return res;
    }
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }
}