// Last updated: 8/24/2026, 6:17:52 AM
1class Solution {
2    public int arrangeCoins(int n) {
3        long x = 1L + 8L * n;
4        double stairs = (-1 + Math.sqrt(x))/2;
5
6        return (int)stairs;
7    }
8}