class Solution {
    // TC: O(n), SC:O(n)
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] res = new int[n];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        dfs(0, -1, graph, res, labels);

        return res;
    }
    private int[] dfs(int node, int parent, Map<Integer, Set<Integer>> graph, int[] res, String labels) {
        char ch = labels.charAt(node);
        int[] cnt = new int[26];
        cnt[ch - 'a']++;
        for (int nxtNode : graph.get(node)) {
            if (nxtNode == parent) {
                continue;
            }
            int[] nxtCnt = dfs(nxtNode, node, graph, res, labels);
            for (int i = 0; i < 26; i++) {
                cnt[i] += nxtCnt[i];
            }
        }
        res[node] = cnt[labels.charAt(node) - 'a'];
        return cnt;
    }
}