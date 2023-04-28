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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        cur = head;
        
        int ind = 0;
        while (k > 0) {
            ListNode dummy = new ListNode();
            ListNode node = dummy;
            int len = (n + k - 1) / k;
            n = n - len;
            while (len > 0) {
                node.next = new ListNode(cur.val);
                node = node.next;
                cur = cur.next;
                len--;
            }
            res[ind++] = dummy.next;
            k--;
        }
        return res;
    }
}
