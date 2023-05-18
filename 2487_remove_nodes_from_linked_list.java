class Solution {
    // TC: O(n), SC: O(n)
    public ListNode removeNodes(ListNode head) {
        Deque<Integer> monoStack = new ArrayDeque<>();
        monoStack.offerLast(head.val);
        head = head.next;
        while (head != null) {
            int val = head.val;
            while (!monoStack.isEmpty() && monoStack.peekLast() < val) {
                monoStack.pollLast();
            }
            monoStack.offerLast(val);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!monoStack.isEmpty()) {
            cur.next = new ListNode(monoStack.pollFirst());
            cur = cur.next;
        }
        return dummy.next;
    }
}