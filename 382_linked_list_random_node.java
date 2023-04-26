//382. Linked List Random Node
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
    private List<Integer> nums;
    private Random rand;
    private int size;
    // TC: O(n), SC: O(n)
    public Solution(ListNode head) {
        nums = new ArrayList<>();
        rand = new Random();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        size = nums.size();
    }
    // TC: O(1), SC: O(n)
    public int getRandom() {
        return nums.get(rand.nextInt(size));
    }
}
