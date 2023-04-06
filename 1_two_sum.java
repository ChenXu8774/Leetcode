class Solution {
    // SC: O(n), TC: O(n)
    // if nums is sorted, we can use two pointers, but it is not the case here
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToInd = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numToInd.containsKey(target - num)) {
                return new int[]{numToInd.get(target - num), i};
            }
            numToInd.put(num, i);
        }
        return null;
    }
}


