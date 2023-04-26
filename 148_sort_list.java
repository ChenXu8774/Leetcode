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
    // TC: O(nlog(n)), SC: O(log(n))
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    private ListNode findMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;  
            }
            else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node2 != null) {
            cur.next = node2;
        }
        else {
            cur.next = node1;
        }
        return dummy.next;
    }
}
