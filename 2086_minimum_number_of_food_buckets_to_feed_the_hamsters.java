class Solution {
    // TC: O(n), SC: O(1)
    public int minimumBuckets(String hamsters) {
        int res = 0;
        for (int i = 0; i < hamsters.length(); i++) {
            if (hamsters.charAt(i) == '.') continue;
            if (i + 1 == hamsters.length() || hamsters.charAt(i + 1) == 'H') {
                if (i == 0 || hamsters.charAt(i - 1) == 'H') return -1;
                res++;
            }
            else {
                res++;
                if (i + 2 < hamsters.length() && hamsters.charAt(i + 2) == 'H') {
                    i += 2;
                }
                else {
                    i++;
                }
            }
        }
        return res;
    }
}