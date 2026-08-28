// Last updated: 8/28/2026, 7:50:42 AM
1class Solution {
2    public int findComplement(int num) {
3        int temp = Integer.highestOneBit(num) << 1;
4
5        return temp - num - 1;
6    }
7}