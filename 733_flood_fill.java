class Solution {
    // TC: O(n), SC: O(min(n, m))
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int rows, cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        rows = image.length;
        cols = image[0].length;
        helper(image, sr, sc, color);
        return image;
    }
    private void helper(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        image[sr][sc] = color;
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            if (Math.min(nr, nc) >= 0 && nr < rows && nc < cols && image[nr][nc] == target) {
                helper(image, nr, nc, color);
            }
        }
        
    }
}