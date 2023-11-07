class Solution {
    // TC: O(n), SC: O(1)
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? -1 : heights[i];
            while (!stack.isEmpty() && heights[stack.peekLast()] >= h) {
                int curH = heights[stack.pollLast()], left = stack.isEmpty() ? -1 : stack.peekLast();
                res = Math.max(res, (i - 1 - left) * curH);
            }
            stack.offerLast(i);
        }
        return res;
    }
}

