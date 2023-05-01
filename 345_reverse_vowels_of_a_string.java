class Solution {
    // TC: O(n), SC: O(1)
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        Set<Character> vowels = new HashSet<>();
        for (char ch : "aeiouAEIOU".toCharArray()) {
            vowels.add(ch);
        }
        while (left < right) {
            while (left < s.length() && !vowels.contains(s.charAt(left))) {
                left++;
            }
            while (right >= 0 && !vowels.contains(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
            left++;
            right--;
        }
        return new String(arr);
    }
}