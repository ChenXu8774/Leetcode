class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int[] dp = new int[]{1, 1};
        
        int res = 1;
        for (int i = 1; i < nums1.length; i++) {
            int[] tmp = new int[]{1, 1};
            if (nums1[i] >= nums1[i - 1]) {
                tmp[0] = Math.max(tmp[0] , dp[0] + 1);
            }
            if (nums1[i] >= nums2[i - 1]) {
                tmp[0]  = Math.max(tmp[0] , dp[1] + 1);
            }
            res = Math.max(res, tmp[0]);
            if (nums2[i] >= nums1[i - 1]) {
                tmp[1] = Math.max(tmp[1], dp[0] + 1);
            }
            if (nums2[i] >= nums2[i - 1]) {
                tmp[1] = Math.max(tmp[1], dp[1] + 1);
            }
            res = Math.max(res, tmp[1]);
            dp = tmp;
        }
        return res;
    }
}