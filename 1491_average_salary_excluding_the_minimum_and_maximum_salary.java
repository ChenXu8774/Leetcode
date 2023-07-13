class Solution {
    // TC: O(n), SC: O(1)
    public double average(int[] salary) {
        int maxSalary = 0, minSalary = Integer.MAX_VALUE;
        double res = 0;
        for (int val : salary) {
            minSalary = Math.min(minSalary, val);
            maxSalary = Math.max(maxSalary, val);
            res += val;
        }
        return (res - minSalary - maxSalary) / (salary.length - 2);
    }
}