class Solution {
    // TC: O(max(n, m)), SC: O(1)
    public Node lowestCommonAncestor(Node p, Node q) {
        Node p1 = p, q1 = q;
        int cntP = 0, cntQ = 0;
        while (p1 != null || q1 != null) {
            if (p1 != null) {
                p1 = p1.parent;
                cntP++;
            }
            if (q1 != null) {
                q1 = q1.parent;
                cntQ++;
            }
        }
        int diff = cntP - cntQ;
        while (true) {
            if (diff > 0) {
                p = p.parent;
                diff--;
            }
            else if (diff < 0) {
                q = q.parent;
                diff++;
            }
            else {
                if (p == q) {
                    break;
                }
                p = p.parent;
                q = q.parent;
            }
        }
        return p;
    }
}