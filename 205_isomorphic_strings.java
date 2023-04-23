class Solution {
    // TC: O(n), SC: O(1)
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if (!map1.containsKey(chs)) {
                map1.put(chs, cht);
            }
            else {
                if (map1.get(chs) != cht) {
                    return false;
                }
            }
            if (!map2.containsKey(cht)) {
                map2.put(cht, chs);
            }
            else {
                if (map2.get(cht) != chs) {
                    return false;
                }
            }
        }
        return true;
    }
}