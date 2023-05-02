class Solution {
    // TC: O(n), SC: O(1)
    public boolean isAnagram(String s, String t) {
        int[] sCnt = new int[26];
        int[] tCnt = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            sCnt[s.charAt(i) - 'a']++;
            tCnt[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCnt[i] != tCnt[i]) {
                return false;
            }
        }
        return true;
    }
}