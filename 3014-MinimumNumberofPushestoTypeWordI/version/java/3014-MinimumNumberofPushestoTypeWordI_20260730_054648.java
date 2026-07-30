// Last updated: 7/30/2026, 5:46:48 AM
1class Solution {
2    public int minimumPushes(String word) {
3        int n = word.length();
4
5        int quotient = n/8;
6
7        return quotient*(quotient+1)*4 + (quotient + 1)*(n%8);
8    }
9}