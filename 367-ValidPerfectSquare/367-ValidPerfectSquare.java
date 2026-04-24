// Last updated: 4/24/2026, 10:34:17 AM
class Solution {
    public boolean isPerfectSquare(int num) {
        long sq = (long)Math.sqrt(num);
        if(sq*sq == num) return true;

        return false;
    }
}