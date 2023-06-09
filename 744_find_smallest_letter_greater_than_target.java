class Solution {
    // TC: O(log(n)), SC: O(1)
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target - letters[mid] >= 0) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left == letters.length ? letters[0] : letters[left];
    }
}