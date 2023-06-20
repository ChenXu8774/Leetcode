class Solution {
    int res = 0;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            if (!graph.containsKey(parent)) {
                graph.put(parent, new HashSet<>());
            }
            graph.get(parent).add(child);
        }
    }
    private int helper(int[] vals, int node, Map<Integer, Set<Integer>> graph) {
        int firstLargest = 0;
        int secondLargest = 0;
        for (int next : graph.get(node))
    }

}