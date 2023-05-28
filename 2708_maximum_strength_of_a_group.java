class Solution {
    // TC: O(n), SC: O(1)
    public long maxStrength(int[] nums) {
        long max_neg = -10;
        boolean containsZero = false;
        int ind = 0;
        while (ind < nums.length && nums[ind] == 0) {
            containsZero = true;
            ind++;
        }
        if (ind == nums.length) {
            return 0;
        }
        long res = nums[ind];
        if (res < 0) {
            max_neg = res;
        }
        int cnt = 1;
        for (int i = ind + 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                containsZero = true;
                continue;
            }
            cnt++;
            if (num < 0) {
                max_neg = Math.max(max_neg, num);
            }
            res *= num;
            //System.out.println(res);
        }
        if (res > 0) {
            return res;
        }
        if (res < 0 && cnt == 1 && containsZero) {
            return 0;
        }
        if (cnt == 1 && !containsZero) {
            return res;
        }
        return res / max_neg;
    }
}