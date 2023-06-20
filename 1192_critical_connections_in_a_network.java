class Solution {
    // TC: O(E + V), SC: O(E + V)
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    Set<List<Integer>> criConn = new HashSet<>();
    Map<Integer, Integer> rank = new HashMap<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for (int i = 0; i < n; i++) {
            rank.put(i, -2);
            graph.put(i, new HashSet<>());
        }
        for (List<Integer> connection : connections) {
            int sortedU = Math.min(connection.get(0), connection.get(1));
            int sortedV = Math.max(connection.get(0), connection.get(1));
            criConn.add(Arrays.asList(sortedU, sortedV));
            graph.get(sortedU).add(sortedV);
            graph.get(sortedV).add(sortedU);
        }
        //System.out.println(criConn);
        dfs(0, 0);
        //System.out.println(criConn);
        return new ArrayList<>(criConn);
    }
    private int dfs(int node, int curRank) {
        if (rank.get(node) != -2) {
            return rank.get(node);
        }
        rank.put(node, curRank);
        int minRank = curRank + 1;
        for (int nextNode : graph.get(node)) {
            if (rank.get(nextNode) == curRank - 1) {
                continue;
            }
            int recurRank = dfs(nextNode, curRank + 1);
            if (recurRank <= curRank) {
                int sortedU = Math.min(nextNode, node);
                int sortedV = Math.max(nextNode, node);
                criConn.remove(Arrays.asList(sortedU, sortedV));
            }
            minRank = Math.min(minRank, recurRank);
        }
        return minRank;
    }
}