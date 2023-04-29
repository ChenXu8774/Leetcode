class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (!visited.contains(n)) {
            int sum = 0;
            visited.add(n);
            while (n > 0) {
                
                int digit = n % 10;
                sum += (digit * digit);
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }
}
