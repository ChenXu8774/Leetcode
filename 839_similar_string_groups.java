class Solution {
    // TC: O(n^2 * m), SC: O(n)
    public int numSimilarGroups(String[] strs) {
        int[] parent = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            parent[i] = i;
        }
        for (int i = 1; i < strs.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isSimilar(strs[i], strs[j])) {
                    int pari = findParent(parent, i);
                    int parj = findParent(parent, j);
                    if (pari > parj) {
                        parent[pari] = parj;
                    }
                    else if (pari < parj) {
                        parent[parj] = pari;
                    }
                }
            }
        }
        for (int i = 1; i < strs.length; i++) {
            parent[i] = findParent(parent, i);
        }
        int res = 1;
        int curMax = 0;
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] > curMax) {
                curMax = i;
                res++;
            }
        }
        return res;
    }
    private boolean isSimilar(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 2 || cnt == 0;
    }
    private int findParent(int[] parent, int i) {
        return parent[i] == i ? i : findParent(parent, parent[i]);
    }
}