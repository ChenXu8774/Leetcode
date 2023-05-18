class Solution {
    // TC: O(n), SC: O(n)
    public ListNode plusOne(ListNode head) {
        head = reverse(head);
        int carry = 1;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            int sum = cur.val + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            pre = cur;
            cur = cur.next;

        }
        
        if (carry == 1) {
            pre.next = new ListNode(1);
        }
        head = reverse(head);
        return head;
        
    }
    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}