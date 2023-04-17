class Solution {
    // TC: O(log(n)), SC: O(1)
    public String numberToWords(int num) {
        Map<Integer, String> basic = new HashMap<>();
        Map<Integer, String> ten = new HashMap<>();
        Map<Integer, String> bulk = new HashMap<>();
        basic.put(1, "One ");
        basic.put(2, "Two ");
        basic.put(3, "Three ");
        basic.put(4, "Four ");
        basic.put(5, "Five ");
        basic.put(6, "Six ");
        basic.put(7, "Seven ");
        basic.put(8, "Eight ");
        basic.put(9, "Nine ");
        basic.put(10, "Ten ");
        basic.put(11, "Eleven ");
        basic.put(12, "Twelve ");
        basic.put(13, "Thirteen ");
        basic.put(14, "Fourteen ");
        basic.put(15, "Fifteen ");
        basic.put(16, "Sixteen ");
        basic.put(17, "Seventeen ");
        basic.put(18, "Eighteen ");
        basic.put(19, "Nineteen ");
        ten.put(2, "Twenty ");
        ten.put(3, "Thirty ");
        ten.put(4, "Forty ");
        ten.put(5, "Fifty ");
        ten.put(6, "Sixty ");
        ten.put(7, "Seventy ");
        ten.put(8, "Eighty ");
        ten.put(9, "Ninety ");
        bulk.put(3, "Billion ");
        bulk.put(2, "Million ");
        bulk.put(1, "Thousand ");
        bulk.put(0, "");
        if (num == 0 ) {
            return "Zero";
        }
        StringBuilder res = new StringBuilder();
        int curBulk = 3;
        while (curBulk >= 0) {
            int block = (int) Math.pow(1000, curBulk);
            int curNum = num / block;
            num = num % block;
            if (curNum == 0) {
                curBulk--;
                continue;
            }
            if (curNum / 100 > 0) {
                res.append(basic.get(curNum / 100));
                res.append("Hundred ");
            }
            curNum = curNum % 100;
            if (curNum == 0) {
                res.append(bulk.get(curBulk));
                curBulk--;
                continue;
            }
            if (basic.containsKey(curNum)) {
                res.append(basic.get(curNum));
            }
            else {
                
                res.append(ten.get(curNum / 10));
                curNum = curNum % 10;
                if (curNum > 0) {
                    res.append(basic.get(curNum));
                }
            }
            res.append(bulk.get(curBulk));
            curBulk--;
        }
        while (res.charAt(res.length() - 1) == ' ')
            res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}