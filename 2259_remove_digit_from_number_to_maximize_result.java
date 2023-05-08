class Solution {
    // TC: O(n), SC: O(1)
    public String removeDigit(String number, char digit) {
        StringBuilder res = new StringBuilder(number);
        int lastOcc = -1;
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch == digit) {
                if (i == number.length() - 1 || ch < number.charAt(i + 1)) {
                    res.deleteCharAt(i);
                    return res.toString();
                }
                lastOcc = i;
            }
        }
        if (lastOcc == -1) {
            return number;
        }
        res.deleteCharAt(lastOcc);
        return res.toString();
        
    }
}