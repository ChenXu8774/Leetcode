class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                isPalindrome[i][j] = true;
            }
        }
        for (int l = 2; l <= len; l++) {
            for (int startInd = 0; startInd <= len - l; startInd++) {
                int endInd = startInd + l - 1;
                if (s.charAt(startInd) == s.charAt(endInd) && isPalindrome[startInd + 1][endInd - 1]) {
                    isPalindrome[startInd][endInd] = true;
                    left = startInd;
                    right = endInd;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}