class Solution {
    // TC: O(log(x)), SC: O(1)
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int build = 0;
        int copy = x;
        while (copy > 0) {
            build = build * 10 + (copy %10);
            copy /= 10;
        }
        return x == build;
    }
}