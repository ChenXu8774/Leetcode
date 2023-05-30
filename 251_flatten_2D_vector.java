class Vector2D {
    private int[][] vec;
    private int curR;
    private int curC;
    public Vector2D(int[][] vec) {
        this.curR = 0;
        this.curC = 0;
        this.vec = vec;
        while (curR < vec.length && vec[curR].length == 0) {
            curR++;
        }
    }
    // TC: O(1), SC: O(1)
    public int next() {
        int val = vec[curR][curC];
        if (curC == vec[curR].length - 1) {
            curR++;
            while (curR < vec.length && vec[curR].length == 0){
                curR++;
            }
            curC = 0; 
        }
        else {
            curC++;
        }
        return val;
    }
    // TC: O(1), SC: O(1)
    public boolean hasNext() {
        if (vec.length == curR) {
            return false;
        }
        if (curR == vec.length - 1 && curC >= vec[curR].length) {
            return false;
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */