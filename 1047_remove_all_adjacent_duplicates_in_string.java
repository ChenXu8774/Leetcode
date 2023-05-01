class Solution {
    // TC: O(n), SC: O(n)
    public String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        int curInd = 0;
        for (int i = 1; i < s.length(); i++) {
            if (curInd == -1 || arr[curInd] != arr[i]) {
                arr[++curInd] = arr[i];
            }
            else {
                curInd--;
            }
        }
        return new String(Arrays.copyOfRange(arr, 0, curInd + 1));
    }
}