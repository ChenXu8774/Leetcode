class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] p : adjacentPairs) {
            int n1 = p[0], n2 = p[1];
            if (!graph.containsKey(n1)) graph.put(n1, new HashSet<>());
            if (!graph.containsKey(n2)) graph.put(n2, new HashSet<>());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        int head = 0;
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                head = key;
                break;
            }
        }
        int[] res = new int[graph.size()];
        Set<Integer> visited = new HashSet<>();
        res[0] = head;
        visited.add(head);
        int cur = head;
        int ind = 1;
        while (ind < graph.size()) {
            int nxt = 0;
            for (int n : graph.get(cur)) {
                if (visited.add(n)) {
                    nxt = n;
                    res[ind++] = n;
                    break;
                }
            }
            cur = nxt;
        }
        return res;
    }
}