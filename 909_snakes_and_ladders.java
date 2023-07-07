class Solution {
    // TC: O(n^2), SC: O(n^2)
    public int snakesAndLadders(int[][] board) {
        int res = 0, n = board.length;
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.offerLast(1);
        visited.add(1);
        while (!q.isEmpty()) {
            int size = q.size();
            //System.out.println(q);
            for (int i = 0; i < size; i++) {
                int cur = q.pollFirst();
                if (cur == n * n) {
                    return res;
                }
                for (int j = cur + 1; j <= Math.min(cur + 6, n * n); j++) {
                    int r = n - 1 - (j - 1) / n, c = ((j - 1) / n) % 2 == 0 ? (j - 1) % n : n - 1 - ((j - 1) % n);
                    if (board[r][c] != -1) {
                        if (visited.add(board[r][c]))
                            q.offerLast(board[r][c]);
                    }
                    else {
                        if (visited.add(j)) {
                            q.offerLast(j);
                        }
                    }
                }
                
            }
            res++;
        }
        return -1;
    }
}