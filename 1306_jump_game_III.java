class Solution {
    // TC: O(n), SC: O(n)
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> target = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            graph.put(i, new HashSet<>());
            if (arr[i] == 0) {
                target.add(i);
            }
            else {
                if (i - arr[i] >= 0) {
                    graph.get(i).add(i - arr[i]);
                }
                if (i + arr[i] < arr.length) {
                    graph.get(i).add(i + arr[i]);
                }
            }
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(start);
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            for (int next : graph.get(cur)) {
                if (target.contains(next)) {
                    return true;
                }
                if (visited.add(next)) {
                    q.offerLast(next);
                }
            }
        }
        return false;
    }
}