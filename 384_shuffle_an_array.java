import java.util.Random;
class Solution {
    int[] copy;
    int[] nums;
    public Solution(int[] nums) {
        copy = new int[nums.length];
        this.nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
            this.nums[i] = nums[i];
        }
    }
    // TC: O(n), SC: O(1)
    public int[] reset() {
        for (int i = 0; i < this.copy.length; i++) {
            this.nums[i] = this.copy[i];
        }
        return this.nums;
    }
    // TC: O(n), SC: O(1)
    public int[] shuffle() {
        Random rand = new Random();
        for (int i = this.nums.length; i >= 1; i--) {
            int randInd = rand.nextInt(i);
            swap(this.nums, randInd, i - 1);
        }
        return this.nums;
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}