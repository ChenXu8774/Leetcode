class Solution {
    public int minFlipsMonoIncr(String s) {
        int leftOne = 0;
        int rightZero = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                rightZero++;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res = Math.min(res, leftOne + rightZero);
            if (ch == '0') {
                rightZero--;
            }
            if (ch == '1') {
                leftOne++;
            }
        }
        return Math.min(res, leftOne);
    }
}