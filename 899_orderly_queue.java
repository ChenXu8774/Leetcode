class Solution {
    // TC: O(nlog(n)), SC: O(n^2)
    public String orderlyQueue(String s, int k) {
        char[] chars = s.toCharArray();
        if (k > 1) {
            Arrays.sort(chars);
            return new String(chars);
        }
        String res = s;
        for (int i = 1; i < s.length(); i++) {
            String cur = s.substring(i) + s.substring(0, i);
            if (cur.compareTo(res) < 0) {
                res = cur;
            }
        }
        return res;
    }
}