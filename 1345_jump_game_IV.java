class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return 0;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(arr[i])) {
                graph.put(arr[i], new HashSet<>());
            }
            graph.get(arr[i]).add(i);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(n - 1);
        visited.add(0);
        Set<Integer> curr = new HashSet<>();
        Set<Integer> other = new HashSet<>();
        curr.add(0);
        other.add(n - 1);
        int res = 0;
        while (!curr.isEmpty()) {
            if (curr.size() > other.size()) {
                Set<Integer> tmp = curr;
                curr = other;
                other = tmp;
            }
            Set<Integer> q = new HashSet<>();
            for (int cur : curr) {
                if (other.contains(cur - 1) || other.contains(cur + 1)) {
                    return res + 1;
                }
                for (int next : graph.get(arr[cur])) {
                    if (other.contains(next)) {
                        return res + 1;
                    }
                    if (visited.add(next)) {
                        q.add(next);
                    }
                }
                graph.get(arr[cur]).clear();
                
                if (cur + 1 < n && visited.add(cur + 1)) {
                    q.add(cur + 1);
                }
                if (cur  - 1 >= 0 && visited.add(cur - 1)) {
                    q.add(cur - 1);
                }
            }
            curr = q;
            res++;
        }
        return n - 1;
    }
}