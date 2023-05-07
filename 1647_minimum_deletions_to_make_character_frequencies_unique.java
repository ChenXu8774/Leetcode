class Solution {
    // TC: O(n + k), SC: O(k)
    public int minDeletions(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            maxCount = Math.max(maxCount, charCount[i]);
        }
        int[] countCount = new int[maxCount + 1];
        for (int i = 0; i < 26; i++) {
            countCount[charCount[i]]++;
        }
        int res = 0;
        //System.out.println(Arrays.toString(countCount));
        for (int i = maxCount; i > 0; i--) {
            if (countCount[i] > 1) {
                countCount[i - 1] += (countCount[i] - 1);
                res += (countCount[i] - 1);
            }
        }
        return res;
    }
}