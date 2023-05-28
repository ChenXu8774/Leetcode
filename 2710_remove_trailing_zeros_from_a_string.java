class Solution {
    // TC: O(n), SC: O(1)
    public String removeTrailingZeros(String num) {
        int ind = num.length() - 1;
        while (ind >= 0 && num.charAt(ind) == '0') {
            ind--;
        }
        //if (ind < 0) {
        //    return "";
        //}
        return num.substring(0, ind + 1);
    }
}