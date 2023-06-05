class Solution {
    // TC: O(n), SC: O(1)
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) {
            return true;
        }
        double slope = coordinates[0][0] == coordinates[1][0] ? Double.MAX_VALUE : (double)(coordinates[0][1] - coordinates[1][1]) / (double)(coordinates[0][0] - coordinates[1][0]);
        for (int i = 2; i < coordinates.length; i++) {
            double curSlope = coordinates[0][0] == coordinates[i][0] ? Double.MAX_VALUE : (double)(coordinates[0][1] - coordinates[i][1]) / (double)(coordinates[0][0] - coordinates[i][0]);
            if (slope != curSlope) {
                return false;
            }
        }
        return true;
    }
}