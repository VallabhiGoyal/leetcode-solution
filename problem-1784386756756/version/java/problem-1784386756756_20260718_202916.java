// Last updated: 7/18/2026, 8:29:16 PM
1class Solution {
2    public long maximumValue(int n, int s, int m) {
3        if(n == 1) return s;
4        long max1 = (long)s + ((n - 1L)/2) * (m - 1L);
5        long max2 = (long)s + (n/2L)*m - ((n/2L) - 1);
6
7        return max1 > max2 ? max1 : max2;
8    }
9}