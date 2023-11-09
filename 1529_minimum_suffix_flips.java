class Solution {
    public int minFlips(String target) {
        int res = 0, cur = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) - '0' == cur) continue;
            cur = 1 - cur;
            res++;
        }
        return res;
    }
}
