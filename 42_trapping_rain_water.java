class Solution {
    // TC: O(n), SC: O(1)
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int maxL = height[left];
        int maxR = height[right];
        while (left <= right) {
            if (height[left] < height[right]) {
                res += Math.max(0, maxL - height[left]);
                maxL = Math.max(maxL, height[left]);
                left++;
            }
            else {
                res += Math.max(0, maxR - height[right]);
                maxR = Math.max(maxR, height[right]);
                right--;
            }
        }
        return res;
    }
}