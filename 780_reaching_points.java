class Solution {
    // TC: log(max(tx, ty)), SC: O(1)
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            //System.out.println("tx: " + tx + " ty: " + ty);
            if (tx == sx && ty == sy) {
                return true;
            }
            if (ty == tx) {
                return false;
            }
            else if (ty > tx) {
                if (ty == sy && tx != sx) {
                    return false;
                }
                if ((ty - sy) % tx == 0) {
                    ty = sy;
                }
                else {
                    ty = ty % tx;
                }
            }
            else {
                if (tx == sx && ty != sy) {
                    return false;
                }
                if ((tx - sx) % ty == 0) {
                    tx = sx;
                }
                else {
                    tx = tx % ty;
                }
            }
            //System.out.println("tx: " + tx + " ty: " + ty);
        }
        
        return (tx == sx) && (ty == sy);
    }
}