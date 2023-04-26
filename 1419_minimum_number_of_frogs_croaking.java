class Solution {
    // TC: O(n), SC: O(1)
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0 || croakOfFrogs.charAt(0) != 'c') {
            return -1;
        }
        Map<Character, Integer> pos = new HashMap<>();
        Map<Integer, Integer> rem = new HashMap<>();
        String croak = "croak";
        for (int i = 0; i < croak.length(); i++) {
            pos.put(croak.charAt(i), i);
        }
        rem.put(0, 1);
        int res = 1;
        int nUnmatch = 1;
        for (int i = 1; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            int ind = pos.get(ch);
            if (ch == 'c') {
                rem.put(ind, rem.getOrDefault(ind, 0) + 1);
                nUnmatch++;
                res = Math.max(res, nUnmatch);
                continue;
            }
            if (!rem.containsKey(ind - 1) || rem.get(ind - 1) == 0) {
                return -1;
            }
            
            rem.put(ind - 1, rem.get(ind - 1) -1);
            if (ind != 4) {
                rem.put(ind, rem.getOrDefault(ind, 0) + 1);
            }
            else {
                nUnmatch--;
            }
            //System.out.println(rem);
            //System.out.println(nUnmatch);
        }
        if (nUnmatch > 0) {
            return -1;
        }
        return res;
    }
}