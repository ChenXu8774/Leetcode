class Solution {
    //TC: O(2^n * n), SC: O(2^n * n)
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int left = 0;
        int right = 1;
        List<Integer> cur = new ArrayList<>();
        addListToResult(nums, 0, cur, res);
        return new ArrayList(res);
    }
    private void addListToResult(int[] nums, int ind, List<Integer> cur, Set<List<Integer>> res) {
        if (ind == nums.length) {
            return;
        }
        addListToResult(nums, ind + 1, cur, res);
        if (cur.size() == 0 || nums[ind] >= cur.get(cur.size() - 1)) {
            cur.add(nums[ind]);
            addListToResult(nums, ind + 1, cur, res);
            if (cur.size() >= 2) {
                res.add(new ArrayList(cur));
            }
            cur.remove(cur.size() - 1);
        }
    }
}