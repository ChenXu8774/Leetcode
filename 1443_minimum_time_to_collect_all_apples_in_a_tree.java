class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        Set<Integer> path = new HashSet<>();
        path.add(0);
        return Math.max(0, helper(0, graph, hasApple, path, memo) - 2);
    }
    private int helper(int node, Map<Integer, Set<Integer>> graph, List<Boolean> hasApple, Set<Integer> path, Map<Integer, Integer> memo) {
        if (memo.containsKey(node)) {
            return memo.get(node);
        }
        int res = hasApple.get(node) ? 2 : 0;
        //System.out.println("before curNode: " + node + " curRes: " + res);
        for (int nxtNode : graph.get(node)) {
            if (path.add(nxtNode)) {
                res += helper(nxtNode, graph, hasApple, path, memo);
                path.remove(nxtNode);
            }
            
        }
        //System.out.println("after curNode: " + node + " curRes: " + res);
        if (!hasApple.get(node) && res > 0) {
            res += 2;
        }
        memo.put(node, res);
        return res;
    }
}