class Solution {
    // TC: O(n), SC: O(n)
    public int minimumRounds(int[] tasks) {
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int task : tasks) {
            count.put(task, count.getOrDefault(task, 0) + 1);
        }
        for (int key : count.keySet()) {
            int n = count.get(key);
            if (n == 1) {
                return -1;
            }
            int residual = n % 3;
            if (residual != 1) {
                res = res + (n / 3) + residual / 2;
            } 
            else {
                res = res + n / 3 - 1 + 2;
            }
        }
        return res;
    }
}