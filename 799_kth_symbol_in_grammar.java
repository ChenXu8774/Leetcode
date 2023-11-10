class Solution {
    public int kthGrammar(int n, int k) {
        int val = 0;
        int level = n ;
        while (level > 1) {
            int ns = (int)Math.pow(2, level - 1);
            if (ns / 2 < k) {
                k = k - ns / 2;
                val = 1 - val;
            }
            level--;
        }
        return val;
    }
}