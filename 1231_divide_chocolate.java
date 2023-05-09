class Solution {
    //TC: O(nlog(m / (k + 1)))SC: O(1)
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int nDiv = getK(sweetness, mid);
            //System.out.println("nDiv " + nDiv + " left " + left + " right " + right);
            if (nDiv >= k + 1) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
    private int getK(int[] arr, int threshold) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int ind = i;
            while (ind < arr.length && sum < threshold) {
                sum += arr[ind];
                ind++;
            }
            if (sum >= threshold)
                res++;
            i = ind - 1;
            //System.out.println(i);
        }
        return res;
    }
}