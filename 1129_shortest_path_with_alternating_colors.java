class Solution {
    //TC: O(n), SC: O(n)
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, Set<Integer>>[] graph = new HashMap[2];
        for (int i = 0; i < 2; i++) {
            graph[i] = new HashMap<>();
            for (int j = 0; j < n; j++) {
                graph[i].put(j, new HashSet<>());
            }
        }

        for (int[] edge : redEdges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if (!graph[0].containsKey(node1)) {
                graph[0].put(node1, new HashSet<>());
            }
            graph[0].get(node1).add(node2);
        }
        for (int[] edge : blueEdges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if (!graph[1].containsKey(node1)) {
                graph[1].put(node1, new HashSet<>());
            }
            graph[1].get(node1).add(node2);
        }
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        if (!graph[0].containsKey(0) && !graph[1].containsKey(0)) {
            Arrays.fill(res, -1);
            res[0] = 0;
            return res;
        }
        
        for (int i = 0; i < 2; i++) {
            int level = 1;
            int color = i;
            Set<Integer>[] visited = new HashSet[2];
            Deque<Integer> q = new ArrayDeque<>();
            for (int j = 0; j < 2; j++) {
                visited[j] = new HashSet<>();
            }
            visited[color].add(0);
            q.offerLast(0);
            while (!q.isEmpty()) {
                int size = q.size();
                color = 1 - color;
                for (int k = 0; k < size; k++) {
                    int curNode = q.pollFirst();
                    for (int nextNode : graph[1 - color].get(curNode)) {
                        if (visited[color].add(nextNode)) {
                            res[nextNode] = Math.min(res[nextNode], level);
                            q.offerLast(nextNode);
                        }
                    }
                }
                level++; 
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }
}