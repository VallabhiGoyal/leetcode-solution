// Last updated: 4/24/2026, 10:29:33 AM
class Solution {
    public int countCommas(int n) {
        if (n < 1000) return 0;
        return n - 999;
    }
}