class Solution {
    // TC: O(n), SC: O(n)
    public int countSubarrays(int[] nums, int k) {
        int res = 0, indK = -1;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.get(0).add(-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                nums[i] = i == 0 ? -1 : nums[i - 1] - 1;
                if (indK == -1) {
                    if (!map.containsKey(nums[i])) {
                        map.put(nums[i], new HashSet<>());
                    }
                    map.get(nums[i]).add(i);
                    continue;
                }
                if (map.containsKey(nums[i])) {
                    res += map.get(nums[i]).size();
                }
                if (map.containsKey(nums[i] - 1)) {
                    res += map.get(nums[i] - 1 ).size();
                }
            }
            else if (nums[i] > k) {
                nums[i] = i == 0 ? 1 : nums[i - 1] + 1;
                if (indK == -1) {
                    if (!map.containsKey(nums[i])) {
                        map.put(nums[i], new HashSet<>());
                    }
                    map.get(nums[i]).add(i);
                    continue;
                }
                if (map.containsKey(nums[i])) {
                    res += map.get(nums[i]).size();
                }
                if (map.containsKey(nums[i] - 1)) {
                    res += map.get(nums[i] - 1 ).size();
                }
            }
            else {
                nums[i] = i == 0 ? 0 : nums[i - 1];
                indK = i;
                if (map.containsKey(nums[i])) {
                    res += map.get(nums[i]).size();
                }
                if (map.containsKey(nums[i] - 1)) {
                    res += map.get(nums[i] - 1 ).size();
                }
            }
        }
        //System.out.println(Arrays.toString(nums));
        return res;
    }
}