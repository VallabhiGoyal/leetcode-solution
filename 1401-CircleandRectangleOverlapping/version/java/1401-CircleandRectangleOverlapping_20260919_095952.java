// Last updated: 9/19/2026, 9:59:52 AM
1class Solution {
2    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
3
4        //closest x
5        int xNear;
6        if(xCenter <= x1) xNear = x1;
7        else if(x1 <= xCenter && xCenter <= x2) xNear = xCenter;
8        else xNear = x2;
9
10        //closest y
11        int yNear;
12        if(yCenter <= y1) yNear = y1;
13        else if(y1 <= yCenter && yCenter <= y2) yNear = yCenter;
14        else yNear = y2;
15
16        double len = Math.sqrt(Math.pow(xCenter - xNear, 2) + Math.pow(yCenter - yNear, 2));
17
18        if(len <= radius) return true;
19        return false;
20    }
21}