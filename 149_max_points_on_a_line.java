class Solution {
    TC: O(n^2), SC: O(n)
    public int maxPoints(int[][] points) {
        int res = 0;
        if (points.length == 1) {
            return 1;
        }
        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            Map<Double, Integer> slopeCount = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] point2 = points[j];
                double slope = point1[0] == point2[0] ? Double.MAX_VALUE : Math.atan2((double)(point1[1] - point2[1]), (double)(point1[0] - point2[0]));
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
            }
            for (double key : slopeCount.keySet()) {
                res = Math.max(res, slopeCount.get(key) + 1);
            }
            System.out.println(slopeCount);
        }
        return res;
    }
}