// Last updated: 9/26/2026, 8:03:17 PM
1class Solution {
2    public int minQueenMoves(int[] source, int[] target) {
3        int sr = source[0];
4        int sc = source[1];
5
6        int tr = target[0];
7        int tc = target[1];
8
9        if(sr == tr && sc == tc) return 0;
10
11        if(sr == tr || sc == tc) return 1;
12
13        if(Math.abs(sr - tr) == Math.abs(sc - tc)) return 1;
14
15        return 2;
16    }
17}