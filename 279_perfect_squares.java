class Solution {
    // TC: O(sqrt(n)^h), SC: O(n ^(h / 2))
    public int numSquares(int n) {
        if (isSquare(n)) {
            return 1;
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(n);
        int res = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curN = q.pollFirst();
                while (curN % 4 == 0) {
                    curN /= 4;
                }
                for (int j = 1; j <= Math.sqrt(curN); j += 2) {
                    if (isSquare(curN - j * j)) {
                        return res + 1;
                    }
                    q.offerLast(curN - j * j);
                }
            }
            res++;
        }
        return res;
    }
    private boolean isSquare(int n) {
        return (int)Math.sqrt(n) * (int)Math.sqrt(n) == n;
    }
}