class Solution {
    // TC: O(n), SC: O(1)
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        List<Boolean> res = new ArrayList<>();
        for (int num : candies) {
            if (num + extraCandies >= max) {
                res.add(true);
            }
            else {
                res.add(false);
            }
        }
        return res;
    }
}