// Last updated: 5/3/2026, 6:52:55 AM
1class Solution {
2    public boolean rotateString(String s, String goal) {
3        int n = s.length();
4        if (n != goal.length()) return false;
5        if(s.equals(goal)) return true;
6
7        s = s + s;
8        if(s.indexOf(goal) != -1) return true;
9
10        return false;
11    }
12}