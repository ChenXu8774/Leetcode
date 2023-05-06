class Solution {
    // TC: O(nlogn), SC: O(1)
    public int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 500 * weights.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int dayNeed = calculateDays(weights, mid);
            //System.out.println("mid " + mid + " dayNeed " + dayNeed);
            if (dayNeed > days) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
    private int calculateDays(int[] weights, int capacity) {
        int nDays = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity) {
                return Integer.MAX_VALUE;
            }
            int total = 0;
            while (i < weights.length && total + weights[i] <= capacity) {
                total += weights[i++];
            }
            i--;
            nDays++;
        }
        return nDays;
    }
}