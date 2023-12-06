class Solution {
    // TC: O(n), SC: O(1)
    public int countHomogenous(String s) {
      int mod = 1000000007;
      int res = 0;
      int cnt = 0;
      for (int i = 0; i < s.length(); i++) {
        if (i == 0 || s.charAt(i) != s.charAt(i - 1)) cnt = 1;
        else cnt++;
        res = (res + cnt) % mod;
      }
      return res;
    }
}