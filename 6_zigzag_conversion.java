class Solution {
    // TC: O(n), SC: O(n)
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] store = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            store[i] = new StringBuilder();
        }
        int curRow = 0;
        int inc = 1;
        for (int i = 0; i < s.length(); i++) {
            store[curRow].append(s.charAt(i));
            if (curRow + inc == numRows) {
                inc = -1;
            }
            if (curRow + inc == -1) {
                inc = 1;
            }
            curRow += inc;
        }
        String res = "";
        for (int i = 0; i < numRows; i++) {
            res = res + store[i].toString();
        }
        return res;
    }
}