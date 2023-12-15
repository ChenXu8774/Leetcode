class Solution {
    //TC: O(n), SC: O(n)
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> forb = new HashSet<>();
        int res = 0;
        for (String str : forbidden) forb.add(str);
        int left = 0;
        for (int i = 0; i < word.length(); i++) {
            int slide = i;
            while (slide >= Math.max(left, i - 9)) {
                if (forb.contains(word.substring(slide, i + 1))) {
                    left = slide + 1;
                    break;
                }
                slide--;
            }
            res = Math.max(i - left + 1, res);
        }
        return res;
    }
}