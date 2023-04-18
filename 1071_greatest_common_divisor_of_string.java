class Solution {
    TC: O(m*n), SC: O(n)
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        while (str1.length() != str2.length()) {
            int len2 = str2.length();
            if (!str2.equals(str1.substring(0, len2))) {
                return "";
            }
            str1 = str1.substring(len2);
            if (str1.length() < str2.length()) {
                String tmp = str1;
                str1 = str2;
                str2 = tmp;
            }
        }
        if (str1.equals(str2)) {
            return str1;
        }
        return "";
    }
}