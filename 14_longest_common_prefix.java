class Solution {
    // TC: O(NL) where N is the length of input array, L is the max length of string in the string array.
    // SC: O(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (char ch : strs[0].toCharArray()) {
            res.append(ch);
        }
        for (String str : strs) {
            if (res.length() == 0 || str.length() == 0) {
                return "";
            }
            for (int i = 0; i < Math.min(str.length(), res.length()); i++) {
                if (str.charAt(i) != res.charAt(i)) {
                    res.setLength(i);
                    break;
                }
                if (i == str.length() - 1) {
                    res.setLength(i + 1);
                }
            }
        }
        return res.toString();
    }
}