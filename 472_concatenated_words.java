class Solution {
    // TC: O(m *n ^3), SC: (m * n)
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dictionary = new HashSet<>();
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String word : words) {
            dictionary.add(word);
            boolean[] dp = new boolean[word.length() + 1];
            dp[0] = true;
            if (word.length() == 1) {
                continue;
            }
            for (int i = 1; i <= word.length(); i++) {
                for (int j = i == word.length() ? 1: 0; j < i; j++) {
                    if (dp[j] && dictionary.contains(word.substring(j, i))) {
                        dp[i] = true;
                    }
                    if (dp[word.length()]) {
                        res.add(word);
                        break;
                    }
                }
            }
        }
        return res;
    }
}