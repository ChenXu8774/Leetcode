class Solution {
    // TC: O(n^2), SC: O(n)
    public String countAndSay(int n) {
        String curV = "1";
        int curN = 1;
        while (curN < n) {
            curV = getCount(curV);
            curN++;
        }
        return curV;
    }
    private String getCount(String s) {
        StringBuilder res = new StringBuilder();
        int left = 0;
        int fast = 1;
        while (left < s.length()) {
            while (fast < s.length() && s.charAt(fast) == s.charAt(left)){
                fast++;
            }
            res.append(Integer.toString(fast - left));
            res.append(s.charAt(left));
            left = fast;
            fast = left + 1;
        }
        return res.toString();
    }
}