class Solution {
    // TC: O(n), SC: O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> container = new HashSet<>();
        for (int num: nums) {
            container.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!container.contains(num)) {
                continue;
            }
            int cnt = 1;
            container.remove(num);
            int copy = num;
            while (container.contains(copy - 1)) {
                copy--;
                container.remove(copy);
                cnt++;
            }
            copy = num;
            while (container.contains(copy + 1)) {
                copy++;
                container.remove(copy);
                cnt++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}