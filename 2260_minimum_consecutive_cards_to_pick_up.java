class Solution {
    //TC: O(n), SC: O(n)
    public int minimumCardPickup(int[] cards) {
        Set<Integer> cur = new HashSet<>();
        int res = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cur.add(cards[i])) {
                continue;
            }
            while (cards[left] != cards[i]) {
                cur.remove(cards[left++]);
            }
            left++;
            res = Math.min(res, cur.size() + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}