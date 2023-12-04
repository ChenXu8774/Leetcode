class Solution {
    // TC: O(n), SC: O(1)
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int res = arr[0];
        for (int i = 0; i < n; i++) {
            int conWin = i == 0 ? k : k - 1;
            int ind = i + 1;
            res = arr[i];
            if (conWin == 0) return res;
            while (ind < arr.length && arr[ind] < arr[i]) {
                conWin--;
                ind++;
                if (conWin == 0) return res;
            }
            i = ind - 1;
        }
        return res;
    }
}