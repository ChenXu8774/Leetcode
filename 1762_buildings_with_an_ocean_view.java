class Solution {
    //TC: O(n), SC: O(1)
    public int[] findBuildings(int[] heights) {
        int curMaxH = -1, ind = heights.length - 1;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > curMaxH) {
                curMaxH = heights[i];
                heights[ind--] = i;
            }
        }
        return Arrays.copyOfRange(heights, ind + 1, heights.length);
    }
}