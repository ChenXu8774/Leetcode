class Solution {
    //TC: O(n), SC: O(n)
    int res = 1;
    public int longestPath(int[] parent, String s) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            if (!graph.containsKey(parent[i])) {
                graph.put(parent[i], new HashSet<>());
            }
            graph.get(parent[i]).add(i);
        }
        helper(s, 0, graph);
        return res;
    }
    private int helper(String s, int node, Map<Integer, Set<Integer>> graph) {
        if (!graph.containsKey(node)) {
            return 1;
        }
        int firstLongest = 0, secondLongest = 0;
        for (int child : graph.get(node)) {
            int len = helper(s, child, graph);
            if (s.charAt(node) == s.charAt(child)) {
                continue;
            }
            
            if (len >= secondLongest) {
                firstLongest = secondLongest;
                secondLongest = len;
            }
            else if (len > firstLongest) {
                firstLongest = len;
            }
        }
        res = Math.max(res, firstLongest + secondLongest + 1);
        return secondLongest + 1;
    }
}