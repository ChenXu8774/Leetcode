class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        for (int i = 0; i < s.length(); i++) {
            size = Character.isDigit(s.charAt(i)) ? size * (s.charAt(i) - '0') : size + 1; 
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                size /= (ch - '0');
                k %= size;
            }
            else {
                if (k % size == 0) {
                    return Character.toString(s.charAt(i));
                } 
                size--;
            }
        }
        return null;
    }
}
