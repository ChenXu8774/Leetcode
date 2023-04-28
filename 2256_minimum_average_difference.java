class Solution {
    //TC: O(n), SC: O(n)
    public int minimumAverageDifference(int[] nums) {
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int res = -1;
        long minDif = Long.MAX_VALUE;
        if (nums.length == 1) {
            return 0;
        }
        int n = nums.length;
        //System.out.println(Arrays.toString(nums));
        for (int i = 1; i <= nums.length; i++) {
            long sum1 = prefix[i - 1] / i;
            long sum2 = i == n ? 0 : (prefix[n - 1] - prefix[i - 1]) / (n - i);
            long cur_dif = Math.abs(sum1 - sum2);
            if (minDif > cur_dif) {
                minDif = cur_dif;
                res = i - 1;
            }
        }
        return res;
    }
}
