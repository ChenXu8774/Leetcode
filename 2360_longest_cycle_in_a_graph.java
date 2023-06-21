class Solution {
    // TC: O(n), SC:O(n)
    int res = -1;
    boolean[] visited;
    public int longestCycle(int[] edges) {
        visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (visited[i]) {
                continue;
            }
            Map<Integer, Integer> rank = new HashMap<>();
            rank.put(i, 0);
            dfs(edges, i, rank);
            System.out.println(rank);
        }
        return res;
    }
    private void dfs(int[] edges, int node, Map<Integer, Integer> rank) {
        if (edges[node] == -1 || visited[node]) {
            return;
        }
        visited[node] = true;
        if (rank.containsKey(edges[node])) {
            res = Math.max(res, rank.get(node) - rank.get(edges[node]) + 1);
        }
        else {
            rank.put(edges[node], rank.get(node) + 1);
            dfs(edges, edges[node], rank);
        }
    }
}