class Solution {
    // TC: O(n^2), SC: O(n^2)
    int mod = 1000000007;
    int[][] table; 
    public int numOfWays(int[] nums) {
        List<Integer> in = new ArrayList<>();
        table = new int[nums.length][nums.length];
        table[0][0] = 1;
        for (int i = 1; i < nums.length; i++) {
            table[i][0] = 1;
            table[i][i] = 1;
            for (int j = 1; j < i; j++) {
                table[i][j] = (table[i - 1][j] + table[i - 1][j - 1]) % mod;
            }
        }
        for (int n : nums) {
            in.add(n);
        }
        
        return (int)dfs(in) - 1;
    }
    private long dfs(List<Integer> nums) {
        if (nums.size() <= 2) return 1;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        long ret = 0;
        int root = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > root) right.add(nums.get(i));
            else left.add(nums.get(i));
        }
        ret = (dfs(left) * dfs(right) % mod) * table[nums.size() - 1][left.size()] %mod;
        return ret;
    }
}å