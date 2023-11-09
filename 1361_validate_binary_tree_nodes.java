class Solution {
    // TC: O(n), SC: O(n)
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> node = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1 && !node.add(leftChild[i])) return false;
            if (rightChild[i] != -1 && !node.add(rightChild[i])) return false;
        }
        if (node.size() != n - 1) return false;
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!node.contains(i)) {
                root = i;
                break;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(root);
        node.clear();
        node.add(root);
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            int left = leftChild[cur], right = rightChild[cur];
            if (left != -1) {
                q.offerLast(left);
                node.add(left);
            }
            if (right != -1) {
                q.offerLast(right);
                node.add(right);
            }
        }
        //System.out.println(node);
        return node.size() == n;
    }
}