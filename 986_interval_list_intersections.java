class Solution {
    // TC: O(max(l1, l2)), SC: O(l1 + l2)
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[][]{};
        }

        int i1 = 0, i2 = 0;
        int l1 = firstList.length;
        int l2 = secondList.length;
        List<int[]> res = new ArrayList<>();
        while (i1 < l1 && i2 < l2) {
            int lo = Math.max(firstList[i1][0], secondList[i2][0]);
            int hi = Math.min(firstList[i1][1], secondList[i2][1]);
            if (lo <= hi) {
                res.add(new int[]{lo, hi});
            }
            if (firstList[i1][1] > secondList[i2][1]) {
                i2++;
            }
            else {
                i1++;
            }
        }
        int[][] ret = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}