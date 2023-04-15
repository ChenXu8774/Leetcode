class Solution {
    // TC: O(n^2), SC: O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int num1 = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < -num1) {
                    left++;
                }
                else if (nums[left] + nums[right] > -num1) {
                    right--;
                }
                else {
                    res.add(Arrays.asList(num1, nums[left], nums[right]));
                    left++;
                    while (left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }
}