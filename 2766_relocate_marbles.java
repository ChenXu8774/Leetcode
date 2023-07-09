class Solution {
    // TC: O(nlogn): SC: O(n)
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> vals = new HashSet<>();
        for (int num : nums) {
            vals.add(num);
        }
        for (int i = 0; i < moveTo.length; i++) {
            if (vals.contains(moveFrom[i])) {
                vals.remove(moveFrom[i]);
                vals.add(moveTo[i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int val : vals) {
            res.add(val);
        }
        Collections.sort(res);
        return res;
    }
}