class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int size = nums.size();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (!map.containsKey(nums.get(i))) map.put(nums.get(i), new ArrayList<>());
            nums.add(nums.get(i));
        }
        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < 2 * size; i++) {
            map.get(nums.get(i)).add(i);
        }
        for (int key : map.keySet()) {
            int moves = 0;
            for (int i = 1; i <  map.get(key).size(); i++) {
                moves = Math.max(moves, (map.get(key).get(i) - map.get(key).get(i - 1)) / 2);
            }
            res = Math.min(res, moves);
        }
        return res;
    }
}