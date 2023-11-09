class Solution {
    // TC: O(n^3), SC: O(n^2)
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < bombs.length; i++) {
            int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
            graph.put(i, new ArrayList<>());
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) continue;
                double d = Math.sqrt(Math.pow(xi - bombs[j][0], 2) + Math.pow(yi - bombs[j][1], 2));
                if (ri >= d) {
                    graph.get(i).add(j);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < bombs.length; i++) {
            Deque<Integer> q = new ArrayDeque<>();
            q.offerLast(i);
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            while (!q.isEmpty()) {
                int cur = q.pollFirst();
                for (int nxt : graph.get(cur)) {
                    if (visited.add(nxt)) {
                        q.offerLast(nxt);
                    }
                }
            }
            res = Math.max(res, visited.size());
        }
        return res;
    }
}