class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) continue;
            int ind = i + 1;
            while (ind < seats.length && seats[ind] == 0) ind++;
            res = (ind == seats.length || i == 0)  ? Math.max(res, ind - i) : Math.max(res, (ind - i + 1) / 2);
            i = ind - 1;
        }
        return res;
    }
}