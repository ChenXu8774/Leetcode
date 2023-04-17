class RandomizedSet {
    Random rand;
    Map<Integer, Integer> valToInd;
    List<Integer> vals;
    public RandomizedSet() {
        valToInd = new HashMap<>();
        vals = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (valToInd.containsKey(val)) {
            return false;
        }
        vals.add(val);
        valToInd.put(val, vals.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!valToInd.containsKey(val)) {
            return false;
        }
        int ind = valToInd.get(val);
        int valLast = vals.get(vals.size() - 1);
        if (valLast == val) {
            vals.remove(vals.size() - 1);
            valToInd.remove(val);
        }
        else {
            vals.set(ind, valLast);
            vals.remove(vals.size() - 1);
            valToInd.remove(val);
            valToInd.put(valLast, ind);
        }
        return true;
    }
    
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }
}