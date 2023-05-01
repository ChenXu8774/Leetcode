class Solution {
    // TC: O(n), SC: O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;
        int oilRem = 0;
        int oilReq = 0;
        for (int i = 0; i < gas.length; i++) {
            oilRem += gas[i] - cost[i];
            oilReq += gas[i] - cost[i];
            if (oilReq < 0) {
                oilReq = 0;
                res = -1;
            }
            else {
                if (res == -1) {
                    res = i;
                }
            }
        }
        if (oilRem < 0) {
            return -1;
        } 
        return res;
    }
}