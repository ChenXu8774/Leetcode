class Solution {
    // TC: O(n), SC: O(1)
    public boolean halvesAreAlike(String s) {
        int diff = 0;
        int len = s.length();
        Set<Character> vowels = new HashSet<>();
        for (char ch : "aeiouAEIOU".toCharArray()) {
            vowels.add(ch);
        }
        for (int i = 0; i < len / 2; i++) {
            if (vowels.contains(s.charAt(i))) {
                diff++;
            }
            if (vowels.contains(s.charAt(i + len / 2))) {
                diff--;
            }
        }
        return diff == 0;
    }
}
