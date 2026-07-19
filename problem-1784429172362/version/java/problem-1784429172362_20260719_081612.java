// Last updated: 7/19/2026, 8:16:12 AM
1class Solution {
2    public boolean canReach(int[] start, int[] target) {
3        int x1 = start[0];
4        int y1 = start[1];
5
6        int x2 = target[0];
7        int y2 = target[1];
8
9        return (x1+x2) % 2 == (y1 + y2) % 2;        
10    }
11}