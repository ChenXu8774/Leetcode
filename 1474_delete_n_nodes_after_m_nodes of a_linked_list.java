class Solution {
    //TC: O(n), SC: O(1)
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode cur = head;
        while (cur != null) {
            ListNode fast = cur;
            int cnt = 1;
            while (cnt < m && fast != null) {
                fast = fast.next;
                cnt++;
            }
            if (fast == null || fast.next == null) {
                return head;
            }
            cur = fast;
            fast = fast.next;
            cnt = 1;
            while (cnt < n && fast != null) {
                fast = fast.next;
                cnt++;
            }
            if (fast == null || fast.next == null) {
                cur.next = null;
                return head;
            }
            cur.next = fast.next;
            cur = cur.next;
        }
        return head;
    }
}