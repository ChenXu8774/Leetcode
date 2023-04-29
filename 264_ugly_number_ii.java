class Solution {
    // TC: O(n), SC: O(n)
    public int nthUglyNumber(int n) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(1);
        int[] primes = new int[]{2, 3, 5};
        for (int i = 1; i < n; i++) {
            int cur = minHeap.poll();
            for (int j = 0; j < 3; j++) {
                if (Integer.MAX_VALUE / primes[j] < cur) {
                    break;
                }
                if (visited.add(cur * primes[j])) {
                    minHeap.add(cur * primes[j]);
                }
            }
        }
        return minHeap.peek();
    }
}
