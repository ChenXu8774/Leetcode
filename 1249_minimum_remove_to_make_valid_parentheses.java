class Solution {
    // TC: O(n), SC: O(n)
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> unMatch = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                continue;
            }
            if (s.charAt(i) == '(') {
                unMatch.offerLast(i);
            }
            else {
                if (unMatch.isEmpty() || s.charAt(unMatch.peekLast()) != '(') {
                    unMatch.offerLast(i);
                }
                else {
                    unMatch.pollLast();
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (unMatch.isEmpty() || unMatch.peekFirst() != i) {
                res.append(s.charAt(i));
            }
            else {
                unMatch.pollFirst();
            }
        }
        return res.toString();
    }
}