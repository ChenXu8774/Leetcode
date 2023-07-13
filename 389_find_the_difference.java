class Solution {
    public char findTheDifference(String s, String t) {
        int[] letter = new int[26];
        for (int i = 0; i < t.length(); i++) {
            if (i == s.length()) {
                letter[t.charAt(i) - 'a']++;
            }
            else {
                letter[t.charAt(i) - 'a']++;
                letter[s.charAt(i) - 'a']--;
            }
        }
        for (char i = 'a'; i <= 'z'; i++) {
            if (letter[i - 'a'] != 0) {
                return i;
            }
        }
        return ' ';
    }
}