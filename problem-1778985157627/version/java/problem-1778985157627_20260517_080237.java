// Last updated: 5/17/2026, 8:02:37 AM
1class Solution {
2    public boolean isAdjacentDiffAtMostTwo(String s) {
3        int n = s.length();
4
5        for(int i = 0; i<n-1; i++){
6            int ch1 = s.charAt(i) - '0';
7            int ch2 = s.charAt(i+1) - '0';
8
9            if(Math.abs(ch1 - ch2) > 2) return false; 
10        }
11
12        return true;
13    }
14}