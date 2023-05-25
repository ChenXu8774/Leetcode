class Solution {
    // TC: O(n), SC: O(d)
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
    private int helper(List<NestedInteger> nestedList, int level) {
        int res = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                res += (nestedList.get(i).getInteger() * level);
            }
            else {
                res += helper(nestedList.get(i).getList(), level + 1);
            }
        }
        return res;
    }

}