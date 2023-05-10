class Solution {
    // TC: O(n), SC: O(n)
    public String removeKdigits(String num, int k) {
        Deque<Character> monoStack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            if (k == 0 || monoStack.isEmpty() || monoStack.peekLast() - num.charAt(i) <= 0) {
                monoStack.offerLast(num.charAt(i));
            }
            else {
                while (k != 0 && !monoStack.isEmpty() && monoStack.peekLast() - num.charAt(i) > 0) {
                    monoStack.pollLast();
                    k--;
                }
                monoStack.offerLast(num.charAt(i));
            }
        }
        while (!monoStack.isEmpty() && monoStack.peekFirst() == '0') {
            monoStack.pollFirst();
        }
        while (k > 0) {
            monoStack.pollLast();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while (!monoStack.isEmpty()) {
            res.append(monoStack.pollFirst());
        }
        if (res.length() == 0) {
            return "0";
        }
        return res.toString();
    }
}