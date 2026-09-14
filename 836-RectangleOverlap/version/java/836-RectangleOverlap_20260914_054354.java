// Last updated: 9/14/2026, 5:43:54 AM
1class Solution {
2    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
3        int left1 = rec1[0];
4        int bottom1 = rec1[1];
5        int right1 = rec1[2];
6        int top1 = rec1[3];
7
8        int left2 = rec2[0];
9        int bottom2 = rec2[1];
10        int right2 = rec2[2];
11        int top2 = rec2[3];
12
13        if (right1 <= left2 || right2 <= left1 ||
14            top1 <= bottom2 || top2 <= bottom1) {
15            return false;
16        }
17
18        return true;
19    }
20}