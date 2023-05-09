class Solution {
    //TC: O(nlogm), SC: O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int time = getTime(piles, mid);
            if (time > h) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
    private int getTime(int[] arr, int k) {
        int res = 0;
        for (int n : arr) {
            res += ((n + k - 1) / k);
        }
        return res;
    }
}