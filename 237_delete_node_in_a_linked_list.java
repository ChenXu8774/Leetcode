class Solution {
    public void deleteNode(ListNode node) {
        ListNode nxt = node.next;
        node.val = nxt.val;
        node.next = nxt.next;
    }
}