class Solution {
    // TC: O(n^2), SC: O(n^2)
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> visited = new HashSet<>();
        int[] nDivP = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            StringBuilder cur = new StringBuilder();
            if (nums[i] % p == 0) {
                nDivP[i + 1] = nDivP[i] + 1;
            }
            else {
                nDivP[i + 1] = nDivP[i];
            }

            int ind = i + 1;
            while (ind > 0 && nDivP[ind] >= nDivP[i + 1] - k) {
                cur.append(nums[ind - 1]);
                cur.append('|');
                ind--;
                if (nDivP[ind] >= nDivP[i + 1] - k)
                    visited.add(cur.toString());
            }
        }
        return visited.size();
    }
}