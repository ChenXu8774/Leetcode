class Solution {
    //TC: n*m*log(m + n), SC: O(m + n)
    public int trapRainWater(int[][] heightMap) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if (heightMap.length == 1 || heightMap[0].length == 1) {
            return 0;
        }
        PriorityQueue<Block> minHeap = new PriorityQueue<>((a, b) -> a.h - b.h);
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        int res = 0;
        for (int i = 0; i < cols; i++) {
            minHeap.add(new Block(0, i, heightMap[0][i]));
            heightMap[0][i] = -1;
            minHeap.add(new Block(rows - 1, i, heightMap[rows - 1][i]));     
            heightMap[rows - 1][i] = -1; 
        }
        for (int i = 0; i < rows; i++) {
            minHeap.add(new Block(i, 0, heightMap[i][0]));
            heightMap[i][0] = -1;
            minHeap.add(new Block(i, cols - 1, heightMap[i][cols - 1]));    
            heightMap[i][cols - 1] = -1;
        }
        while (!minHeap.isEmpty()) {
            Block cur = minHeap.poll();
            int curBond = cur.h;
            for (int[] dir : dirs) {
                int nr = cur.r + dir[0];
                int nc = cur.c + dir[1];
                if (Math.min(nr, nc) >= 0 && nr < rows && nc < cols && heightMap[nr][nc] != -1) {
                    res += Math.max(0, curBond - heightMap[nr][nc]);
                    minHeap.offer(new Block(nr, nc, Math.max(curBond, heightMap[nr][nc])));
                    heightMap[nr][nc] = -1;
                }
            }
        }
        return res;
    }
    private static class Block {
        int r;
        int c; 
        int h;
        Block(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }
}