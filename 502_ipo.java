class Solution {
    // TC: O(nlogn), SC: O(n)
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] ipos = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            ipos[i][0] = profits[i];
            ipos[i][1] = capital[i];
        }
        Arrays.sort(ipos, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int ipoId = 0;
        while (ipoId < profits.length && ipos[ipoId][1] <= w) {
            pq.offer(ipos[ipoId++]);
        }
        while (k > 0 && !pq.isEmpty()) {
            int[] curIPO = pq.poll();
            k--;
            w = w + curIPO[0];
            while (ipoId < profits.length && ipos[ipoId][1] <= w) {
                pq.offer(ipos[ipoId++]);
            }
        }
        return w;
    }
}