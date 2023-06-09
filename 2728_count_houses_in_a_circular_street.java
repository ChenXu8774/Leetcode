class Solution {
    // TC: O(k), SC: O(1)
    public int houseCount(Street street, int k) {
        while (k > 0) {
            street.closeDoor();
            street.moveLeft();
            k--;
        }
        int res = 0;
        while (!street.isDoorOpen()) {
            res++;
            street.openDoor();
            street.moveRight();
        }
        return res;
    }
}