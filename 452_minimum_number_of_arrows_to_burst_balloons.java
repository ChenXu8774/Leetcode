class Solution {
    // TC: O(nlogn), SC: O(n)
    public int findMinArrowShots(int[][] points) {
        int res = 0;
        int left = 0;
        int right = 1;
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return 0;
            }
            if (a[0] < b[0]) {
                return -1;
            }
            return 1;
        });
        while (left < points.length) {
            int leftBound = points[left][0];
            int rightBound = points[left][1];
            while (right < points.length && points[right][0] <= rightBound) {
                leftBound = points[right][0];
                rightBound = Math.min(points[right][1], rightBound);
                right++;
            }
            res++;
            left = right;
            right++;
        }
        return res;
    }
}