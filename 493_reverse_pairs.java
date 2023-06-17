class Solution {
    // TC: O(n), SC: O(nlogn * logn)
    int res = 0;
    public int reversePairs(int[] nums) {
        helper(nums);
        return res;
    }
    private int[] helper(int[] arr) {
        int l = arr.length;
        if (l <= 1) {
            return arr;
        }
        int[] left = helper(Arrays.copyOfRange(arr, 0, l / 2));
        int[] right = helper(Arrays.copyOfRange(arr, l/ 2, l));
        for (int num : right) {
            int ind = findIndex(left, num);
            res += (l / 2 - ind);
        }
        return merge(left, right);

    }
    private int findIndex(int[] arr, int target) {
        int left = 0, right = arr.length;
        //System.out.println(arr.length);
        while (left < right) {
            int mid = left + (right - left) / 2;
            //System.out.println("left: " + left + " right: " + right + " mid: " + mid);
            if (arr[mid] / 2. <= target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
    private int[] merge(int[] arr1, int[] arr2) {
        int ind1 = 0, ind2 = 0, ind = 0;
        int[] ret = new int[arr1.length + arr2.length];
        while (ind1 < arr1.length && ind2 < arr2.length) {
            if (arr1[ind1] < arr2[ind2]) {
                ret[ind++] = arr1[ind1++];
            }
            else {
                ret[ind++] = arr2[ind2++];
            }
        } 
        while (ind1 < arr1.length) {
            ret[ind++] = arr1[ind1++];
        }
        while (ind2 < arr2.length) {
            ret[ind++] = arr2[ind2++];
        }
        return ret;
    }
}