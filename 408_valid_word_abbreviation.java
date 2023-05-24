class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        return helper(word, 0, abbr, 0);
    }
    // TC: O(n), SC: O(n)
    private boolean helper(String word, int indW, String abbr, int indA) {
        if (indW >= word.length() || indA >= abbr.length()) {
            if (indW == word.length() && indA == abbr.length()) {
                return true;
            }
            return false;
        }
        if (Character.isDigit(abbr.charAt(indA))) {
            if (abbr.charAt(indA) == '0'){
                return false;
            }
            int num = 0;
            while (indA < abbr.length() && Character.isDigit(abbr.charAt(indA))) {
                num = num * 10 + (abbr.charAt(indA) - '0');
                indA++;
            }
            return helper(word, indW + num, abbr, indA);
        }
        if (word.charAt(indW) == abbr.charAt(indA)) {
            return helper(word, indW + 1, abbr, indA + 1);
        }
        return false;

    }

}