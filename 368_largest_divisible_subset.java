class Solution {
    // TC: O(n^2), SC: O(n)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[] dp = new ArrayList[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add(nums[0]);
        int resInd = 0;
        int resMax = 1;
        for (int i = 1; i < nums.length; i++) {
            
            int maxLen = 1;
            int maxInd = i;
            for (int j = 0; j < i; j++) {
                int lastNum = dp[j].get(dp[j].size() - 1);
                if (nums[i] % lastNum == 0 && dp[j].size() >= maxLen) {
                    maxInd = j;
                    maxLen = dp[j].size();
                }
            }
            if (maxInd != i) {
                for (int num : dp[maxInd]) {
                    dp[i].add(num);
                }
            }
            dp[i].add(nums[i]);
            if (dp[i].size() > resMax) {
                resMax = dp[i].size();
                resInd = i;
            }
        }
        return dp[resInd];
    }
}