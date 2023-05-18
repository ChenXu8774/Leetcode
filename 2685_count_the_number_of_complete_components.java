class Solution {
    // TC: O(n + e), SC: O(n)
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            Deque<Integer> q = new ArrayDeque<>();
            q.offerLast(i);
            visited.add(i);
            int cntNode = 1;
            int cntEdge = 0;
            while (!q.isEmpty()) {
                int cur = q.pollFirst();
                cntEdge += graph.get(cur).size();
                for (int nxt : graph.get(cur)) {
                    if (visited.add(nxt)) {
                        cntNode++;
                        
                        q.offerLast(nxt);
                    }
                }
            }
            if (cntNode * (cntNode - 1) == cntEdge) {
                res++;
            }
            
        }
        return res;
    }
}