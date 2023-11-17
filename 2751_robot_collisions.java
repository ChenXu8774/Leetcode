class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int[][] robs = new int[positions.length][4];
        for (int i = 0; i < positions.length; i++) {
            robs[i][0] = positions[i];
            robs[i][1] = healths[i];
            robs[i][2] = directions.charAt(i) == 'R' ? 1 : -1;
            robs[i][3] = i;
        }
        Arrays.sort(robs, (a, b) -> a[0] - b[0]);
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < robs.length; i++) {
            if (stack.isEmpty() || stack.peekLast()[2] == robs[i][2] || stack.peekLast()[2] == -1) {
                stack.offerLast(robs[i]);
                continue;
            }
            boolean add = true;
            while (!stack.isEmpty() && stack.peekLast()[2] != robs[i][2] && stack.peekLast()[2] == 1) {
                if (stack.peekLast()[1] == robs[i][1]) {
                    stack.pollLast();
                    add = false;
                    break;
                }
                else if (stack.peekLast()[1] < robs[i][1]) {
                    robs[i][1]--;
                    stack.pollLast();
                }
                else {
                    stack.peekLast()[1]--;
                    add = false;
                    break;
                }
            }
            if (add) stack.offerLast(robs[i]);
        }
        List<int[]> ret = new ArrayList<>();
        List<Integer> res = new ArrayList();
        while (!stack.isEmpty()) {
            ret.add(stack.pollFirst());
        }
        Collections.sort(ret, (a, b) -> a[3] - b[3]);
        for (int i = 0; i < ret.size(); i++) {
            res.add(ret.get(i)[1]);
        }
        return res;
    }
}