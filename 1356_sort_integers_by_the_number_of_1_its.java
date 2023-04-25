class Solution {
    // TC: n*log(n)*log(m), SC: n
    public int[] sortByBits(int[] arr) {
        Integer[] arr1 = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        Arrays.sort(arr1, (a, b) -> {
            return Integer.bitCount(a) == Integer.bitCount(b) ? a - b : Integer.bitCount(a) - Integer.bitCount(b);
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr1[i];
        }
        return arr;
    }
}