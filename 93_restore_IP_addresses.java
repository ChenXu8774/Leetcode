class Solution {
    public List<String> restoreIpAddresses(String s) {
        // TC: O(n ^ 3), SC: O(n)
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        int blockSoFar = 0;
        dfs(s, 0, 0, path, 0, res);
        return res;

    }
    private void dfs(String s, int curInd, int curNblock, StringBuilder path, int blockSoFar, List<String> res) {
        //System.out.println(path);
        if (blockSoFar > 255) {
            return;
        }
        if (curInd == s.length() ) {
            if (curNblock == 3)
                res.add(path.toString());
            return;
        }
        if (path.isEmpty() || path.charAt(path.length() - 1) != '0' || (s.charAt(curInd - 1) == '0' && blockSoFar != 0)) {
            dfs (s, curInd + 1, curNblock, path.append(s.charAt(curInd)), blockSoFar * 10 + (s.charAt(curInd) - '0'), res);
            path.deleteCharAt(path.length() - 1);   
        }
        if (!path.isEmpty() && path.charAt(path.length() - 1) != '.' && curNblock != 3) {
            dfs (s, curInd, curNblock + 1, path.append('.'), 0, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}