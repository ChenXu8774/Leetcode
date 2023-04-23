/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // TC: O(n), SC: O(1)
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyHead1 = new ListNode();
        ListNode dummyHead2 = new ListNode();
        ListNode cur1 = dummyHead1;
        ListNode cur2 = dummyHead2;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            if (count == 0) {
                cur1.next = cur;
                cur1 = cur1.next;
            }
            else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            count = 1 - count;
            cur = cur.next;
        }
        cur2.next = null;
        cur1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}