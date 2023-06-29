class Solution {
    // TC: O(nlogn), SC: O(n)
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : arr) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(arr);
        for (int num : arr) {
            if (cnt.get(num) == 0) {
                continue;
            }
            cnt.put(num, cnt.get(num) - 1);
            if (num >= 0) {
                if (!cnt.containsKey(2 * num) || cnt.get(2 * num) == 0) {
                    return false;
                }
                cnt.put(2 * num, cnt.get(2 * num) - 1);
            }
            else {
                //System.out.println(num % 2);
                if (num % 2 == -1 || !cnt.containsKey(num / 2) || cnt.get(num / 2) == 0) {
                    return false;
                }
                cnt.put(num / 2, cnt.get(num / 2) - 1);
            }
            
        }
        return true;
    }
}