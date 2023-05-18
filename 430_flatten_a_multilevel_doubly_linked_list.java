class Solution {
    // TC: O(n), SC: O(n)
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node dummy = new Node();
        dummy.next = head;
        head.prev = dummy;
        dfsHelper(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
    }
    private Node dfsHelper(Node curr, Node next) {
        if (next == null) {
            return curr;
        }
        curr.next = next;
        next.prev = curr;
        Node tempNext = next.next;
        Node tail = dfsHelper(next, next.child);
        next.child = null;
        return dfsHelper(tail, tempNext);
    }
}