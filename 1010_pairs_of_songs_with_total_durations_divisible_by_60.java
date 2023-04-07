class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> timeToCount = new HashMap<>();
        int res = 0;
        for (int t : time) {
            t = t % 60;
            int rem = (60 - t) % 60;
            res += timeToCount.getOrDefault(rem, 0);
            timeToCount.put(t, timeToCount.getOrDefault(t, 0) + 1);
        }
        return res;
    }
}
