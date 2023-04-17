class Solution {
    public int minimumDeviation(int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2 == 1? nums[i] * 2 : nums[i];
            min = Math.min(min, nums[i]);
        }
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b) -> b - a);
        for (int num : nums) {
            maxPq.offer(num);
        }
        while (maxPq.size() == nums.length) {
            int val = maxPq.poll();
            res = Math.min(res, val - min);
            if (val % 2 == 0) {
                val = val / 2;
                min = Math.min(min, val);
                maxPq.offer(val);
            }
        }
        return res;
    }
}