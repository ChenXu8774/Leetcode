class Solution {
    // TC: O(n), SC: O(n)
    Map<Integer, Set<Integer>> graph;
    int[] subt;
    int[] ans;
    int N;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        subt = new int[n];
        ans = new int[n];
        Arrays.fill(subt, 1);
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        dfs1(0, -1);
        dfs2(0, -1);
        return ans;

    }
    private void dfs1(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            dfs1(child, node);
            subt[node] += subt[child];
            ans[node] += ans[child] + subt[child];
        }
    }
    private void dfs2(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            ans[child] = ans[node] + N - subt[child] - subt[child];
            dfs2(child, node);
        }
    }
}