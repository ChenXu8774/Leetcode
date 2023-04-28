class Solution {
    // TC: O(n), SC: O(1)
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[][] cnt = new int[2][26];
        for (int i = 0; i < word1.length(); i++) {
            cnt[0][word1.charAt(i) - 'a']++;
            cnt[1][word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (Math.abs(cnt[0][i] - cnt[1][i]) > 3) {
                return false;
            }
        }
        return true;
    }
}
