class Solution {
    //TC: O(2^N), SC: O()
    private static Map<Integer, Set<Integer>> conflict;
    public int maxLength(List<String> arr) {
        conflict = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            conflict.put(i, new HashSet<>());
            if (containsDup(arr.get(i))) {
                continue;
            }
            for (int j = 0; j < arr.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (isConflict(arr.get(i), arr.get(j))) {
                    conflict.get(i).add(j);
                }
            }
        }
        StringBuilder cur = new StringBuilder();
        int[] res = new int[1];
        Set<Integer> excludeInd = new HashSet<>();
        helper(arr, 0, cur, res, excludeInd);
        return res[0];
    }

    private void helper(List<String> arr, int ind, StringBuilder cur, int[] res, Set<Integer> excludeInd) {
        //System.out.println(cur.toString());
        if (ind == arr.size()) {
            res[0] = Math.max(res[0], cur.length());
            return;
        }

        helper(arr, ind + 1, cur, res, excludeInd);
        Set<Integer> added = new HashSet<>();
        if (!excludeInd.contains(ind) && !containsDup(arr.get(ind))) {
            for (int i : conflict.get(ind)) {
                if (excludeInd.add(i)) {
                    added.add(i);
                }
            }
            cur.append(arr.get(ind));
            helper(arr, ind + 1, cur, res, excludeInd);
            for (int i : added) {
                excludeInd.remove(i);
            }
            for (int i = 0; i < arr.get(ind).length(); i++) {
                cur.deleteCharAt(cur.length() - 1);
            }
        } 
        
    }
    private boolean isConflict(String a, String b) {
        int[] letterCnt = new int[26];
        for (int i = 0; i < a.length(); i++) {
            letterCnt[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            if (letterCnt[b.charAt(i) - 'a'] == 1) {
                return true;
            }
        }
        return false;
    }
    private boolean containsDup(String a) {
        int[] letterCnt = new int[26];
        for (int i = 0; i < a.length(); i++) {
            if (letterCnt[a.charAt(i) - 'a'] == 1) {
                return true;
            }
            letterCnt[a.charAt(i) - 'a']++;
        }
        return false;
    }
}