class Solution {
    // TC: O(k), SC: O(k)
    int m, n;
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        this.m = m;
        this.n = n;
        Set<Integer> blocks = new HashSet<>();
        for (int[] coord : coordinates) {
            blocks.add(coord[0] * n + coord[1]);
        }
        long[] res = new long[5];
        for (int[] cord : coordinates) {
            int r = cord[0], c = cord[1];
            int cnt = 0;
            cnt = check(r, c, blocks);
            res[cnt]++;
            cnt = check(r + 1, c, blocks);
            res[cnt]++;
            cnt = check(r, c + 1, blocks);
            res[cnt]++;
            cnt = check(r + 1, c + 1, blocks);
            res[cnt]++;
        }
        //System.out.println(Arrays.toString(res));
        res[0] = (long)(m - 1) * (long)(n - 1);
        for (int i = 1; i <= 4; i++) {
            res[i] = res[i] / (long)i;
            res[0] -= res[i];
        } 

        return res;
    }
    private int check(int r, int c, Set<Integer> blocks) {
        if (r == m || c == n || r == 0 || c == 0) {
            return 0;
        }
        int cnt = 0, code = r* n + c;
        if (blocks.contains(code)) {
            cnt++;
        }
        if (blocks.contains(code - 1)) {
            cnt++;
        }
        if (blocks.contains(code - n)) {
            cnt++;
        }
        if (blocks.contains(code - n - 1)) {
            cnt++;
        }
        return cnt;
    }
}