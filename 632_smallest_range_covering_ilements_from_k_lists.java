class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int[] ids = new int[n];
        
        Arrays.fill(ids, 1);
        int l = -100000, r = 100000;
        for (int i = 0; i < nums.size(); i++) {
            nums.get(i).add(0, i);
            
        }
        PriorityQueue<List<Integer>> minH = new PriorityQueue<>((a, b) -> a.get(ids[a.get(0)]) - b.get(ids[b.get(0)]));
        for (List<Integer> lst : nums) {
            minH.offer(lst);
        }
        while (minH.size() == n) {
            List<Integer> cur = minH.poll();
            int arrId = cur.get(0);
            int left = cur.get(ids[arrId]);
            int right = left;
            for (int aId = 0; aId < n; aId++) {
                right = Math.max(right, nums.get(aId).get(ids[aId]));
            }
             if (right - left < r - l) {
                r = right;
                l = left;
            }
            ids[arrId]++;
            if (ids[arrId] < nums.get(arrId).size()) minH.offer(cur); 
        }
        return new int[]{l, r};
    }
}