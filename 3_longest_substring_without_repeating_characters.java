class Solution {
    public int lengthOfLongestSubstring(String s) {
        //TC: O(n), SC: O(n)
        Set<Character> charContainer = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (charContainer.add(ch)) {
                res = Math.max(res, charContainer.size());
            }
            else {
                while (s.charAt(left) != s.charAt(right)) {
                    charContainer.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
