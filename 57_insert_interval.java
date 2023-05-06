class Solution {
    // TC: O(n), SC: O(1) 
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        if (intervals.length == 0) {
            res.add(newInterval);
            return res.toArray(new int[res.size()][2]);
        }
        boolean added = false;
        for (int i = 0; i < intervals.length; i++) {
            if (right < intervals[i][0]) {
                if (!added) {
                    res.add(newInterval);
                    added = true;
                }
                
                res.add(intervals[i]);
                continue;
            }
            if (intervals[i][1] < left) {
                res.add(intervals[i]);
                continue;
            }
            int ind = i;
            while (ind + 1 < intervals.length && intervals[ind + 1][0] <= right) {
                ind++;
            } 
            res.add(new int[]{Math.min(left, intervals[i][0]), Math.max(right, intervals[ind][1])});
            i = ind;
            added = true;
        }
        if (left > intervals[intervals.length - 1][1]) {
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[res.size()][2]);
    }
}