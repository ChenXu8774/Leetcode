class Solution {
    // TC: O(n), SC: O(n)
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }
        Set<Integer> words = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            if (!bank[i].equals(startGene))
                words.add(i);
        }
        Deque<String> q = new ArrayDeque<>();
        q.offerLast(startGene);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++){
                String cur = q.pollFirst();
                System.out.println(words);
                List<Integer> inds = new ArrayList<>(words);
                for (int id : inds) {
                    if (findNDiff(bank[id], cur) == 1) {
                        words.remove(id);
                        if (bank[id].equals(endGene)) {
                            return res + 1;
                        }
                        q.offerLast(bank[id]);
                    }
                }
            }
            res++;
        }
        return -1;
    }
    private int findNDiff(String s1, String s2) {
        int ret = 0;
        for (int i = 0; i < 8; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ret++;
            }
        }
        return ret;
    }
}