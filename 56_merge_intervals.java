class Solution {
    // TC: O(nlogn), SC: O(n)
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int left = 0, right = 0;
        while (left < intervals.length) {
            int rightBound = intervals[left][1];
            while (right < intervals.length && intervals[right][0] <= rightBound) {
                rightBound = Math.max(rightBound, intervals[right][1]);
                right++;
            }
            res.add(new int[]{intervals[left][0], rightBound});
            left = right;
        }
        int[][] ret = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ret[i][0] = res.get(i)[0];
            ret[i][1] = res.get(i)[1];
        }
        return ret;
    }
}