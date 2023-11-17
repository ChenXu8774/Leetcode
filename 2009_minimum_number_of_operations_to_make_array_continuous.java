class Solution {
    // TC: O(nlogn), SC: O(n)
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ind = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[ind] == nums[i]) i++;
            if (i < nums.length) nums[++ind] = nums[i];
        }
        nums = Arrays.copyOfRange(nums, 0, ind + 1);
        //System.out.println(Arrays.toString(nums));
        int res = n;
        for (int i = 0; i < nums.length; i++) {
            int l = nums[i], r = l + n - 1;
            ind = binarySearch(nums, r);
            res = Math.min(res, n - (ind - i + 1));
        }
        return res;
    }
    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (nums[mid] > target) right = mid - 1;
            else left = mid;
        }
        return left;
    }
}