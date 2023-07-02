class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 4) {
            res.add(Arrays.asList(2, 2));
            return res;
        }
        if (n <= 3) {
            return res;
        }
        if (n % 2 == 1) {
            if (isPrime(n - 2)) {
                res.add(Arrays.asList(2, n - 2));
            }
            return res;
        }
        int start = 3;
        while (2 * start <= n) {
            if (isPrime(start) && isPrime(n - start)) {
                res.add(Arrays.asList(start, n - start));
            }
            start += 2;
        }
        return res;
        
    }
    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}