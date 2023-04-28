class Solution {
    // TC: O(N + E), SC: O(N + E)
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Set<Integer>[] group = new HashSet[2];
        group[0] = new HashSet<>();
        group[1] = new HashSet<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] rel : dislikes) {
            int node1 = rel[0];
            int node2 = rel[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        int ind = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int j = 1; j <= n; j++) {
            if (group[0].contains(j) || group[1].contains(j)) {
                continue;
            }
            q.offerLast(j);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int cur = q.pollFirst();
                    group[ind].add(cur);
                    for (int nxt : graph.get(cur)) {
                        if (group[ind].contains(nxt)) {
                            return false;
                        }
                        if (!group[0].contains(nxt) && !group[1].contains(nxt)) {
                            q.offerLast(nxt);
                            group[1 - ind].add(nxt);
                        }
                    }
                }
                ind = 1 - ind;
            }
        }
        return true;
    }
}
