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
    //TC: O(n), SC: O(n)
    Map<Integer, ListNode> table = new HashMap<>();
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy, 0);
        return dummy.next;
    }
    private void helper(ListNode node, int prefixSum) {
        if (node == null) return;
        prefixSum += node.val;
        if (table.containsKey(prefixSum)) {
            ListNode startNode = table.get(prefixSum);
            removeNodes(startNode, node, prefixSum);
            helper(node.next, prefixSum);
        }
        else {
            table.put(prefixSum, node);
            helper(node.next, prefixSum);
        }
    }
    private void removeNodes(ListNode head, ListNode end, int sum) {
        ListNode cur = head;
        cur = cur.next;
        while (cur != end) {
            sum += cur.val;
            table.remove(sum);
            cur = cur.next;
        }
        head.next = end.next;
    }
}