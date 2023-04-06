class Solution {
    // SC: O(n), TC: O(n)
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : arr) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        Set<Integer> countSet = new HashSet<>();
        for (int key : numCount.keySet()) {
            if (!countSet.add(numCount.get(key))) {
                return false;
            }
              
        }
        return true;
    }
}
