class Solution {
    // TC: O(n^2), SC: O(n)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            if (i == 1) {
                res.add(cur);
                continue;
            }
            for (int j = 1; j <= i - 2; j++) {
                cur.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}