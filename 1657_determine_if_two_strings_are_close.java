class Solution {
    //TC: O(n), SC: O(1)
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> w1 = new HashMap<>();
        Map<Character, Integer> w2 = new HashMap<>();
        for (char ch : word1.toCharArray()) {
            w1.put(ch, w1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : word2.toCharArray()) {
            w2.put(ch, w2.getOrDefault(ch, 0) + 1);
        }
        if (!w1.keySet().equals(w2.keySet())) {
            return false;
        }
        Map<Integer, Integer> cnt1 = new HashMap<>();
        Map<Integer, Integer> cnt2 = new HashMap<>();
        for (char ch : w1.keySet()) {
            int c1 = w1.get(ch);
            int c2 = w2.get(ch);
            cnt1.put(c1, cnt1.getOrDefault(c1, 0) + 1);
            cnt2.put(c2, cnt2.getOrDefault(c2, 0) + 1);
        }
        for (int key : cnt1.keySet()) {
            if (cnt1.get(key) != cnt2.get(key)) {
                return false;
            }
        }
        return true;
    }
}