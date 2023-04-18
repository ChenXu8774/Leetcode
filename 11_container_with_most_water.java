class Solution {
    //TC: O(n), SC: O(1)
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                res = Math.max(res, (right - left) * height[left]);
                left++;
            }
            else {
                res = Math.max(res, (right - left) * height[right]);
                right--;
            }
        }
        while (left < right) {
            if (height[left] < height[right]) {
                res = Math.max(res, (right - left) * height[left]);
                left++;
            }
            else {
                res = Math.max(res, (right - left) * height[right]);
                right--;
            }
        }
        return res;
    }
}