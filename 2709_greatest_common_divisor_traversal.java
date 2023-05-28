class Solution {
    // TC: O(sqrt(m) * n), SC: O(n)
    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int len = nums.length;
        int[] father = new int[len];
        int[] cnt = new int[len];
        Map<Integer, Integer> fa = new HashMap<>();
        for (int i = 0; i < len; i++) {
            father[i] = i;
            cnt[i] = 1;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                return false;
            }
            int val = nums[i];
            for (int x = 2; x * x <= val; x++) {
                if (val % x != 0) {
                    continue;
                }
                if (!fa.containsKey(x)) {
                    fa.put(x, i);
                }
                else {
                    merge(father, cnt, i, fa.get(x));
                }
                while (val % x == 0) {
                    val /= x;
                }
            }
            if (val > 1) {
                if (!fa.containsKey(val)) {
                    fa.put(val, i);
                }
                else {
                    merge(father, cnt, i, fa.get(val));
                }
            }
        }
        return cnt[0] == len;
    }
    private void merge(int[] father, int[] cnt, int i, int j) {
        i = findRootFather(father, i);
        j = findRootFather(father, j);
        if (i == j) {
            return;
        }
        if (i < j) {
            cnt[i] += cnt[j];
            father[j] = i;
        }
        else {
            cnt[j] += cnt[i];
            father[i] = j;
        }
    }
    private int findRootFather(int[] father, int val) {
        if (father[val] == val) {
            return val;
        }
        return findRootFather(father, father[val]);
    }
}