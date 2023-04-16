class Solution {
    public long distinctNames(String[] ideas) {
        // TC: O(m*n), SC: O(m*n)
        Set<String>[] dic = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            dic[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            dic[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        long res = 0;
        for (int i = 0; i < 25; i++) {
            for (int j = i + 1; j < 26; j++) {
                long nOverlap = 0;
                for (String s : dic[j]) {
                    if (dic[i].contains(s)) {
                        nOverlap++;
                    }
                }
                res = res + 2 * (dic[i].size() - nOverlap) * (dic[j].size() - nOverlap);
            }
            
        }
        return res;
    }
}