class Solution {
    // TC: O(n), SC: O(1)
    public long appealSum(String s) {
        int[] lastInd = new int[26];
        Arrays.fill(lastInd, -1);
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            lastInd[s.charAt(i) - 'a'] = i;
            for (int j = 0; j < 26; j++) {
                res += lastInd[j] + 1;   
            }
        }
        return res;
    }
}