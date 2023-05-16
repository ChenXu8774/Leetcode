/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // TC: O(max(l1, l2)), SC: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lA = 0;
        int lB = 0;
        while (nodeA != null || nodeB != null) {
            if (nodeA != null) {
                lA++;
                nodeA = nodeA.next;
            }
            if (nodeB != null) {
                lB++;
                nodeB = nodeB.next;
            }
        }
        int diff = lA - lB;
        while (headA != null && headB != null) {
            if (diff > 0) {
                headA = headA.next;
                diff--;
            }
            else if (diff < 0) {
                headB = headB.next;
                diff++;
            }
            else {
                if (headA == null || headB == null) {
                    return null;
                }
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}