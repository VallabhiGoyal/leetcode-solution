// Last updated: 9/20/2026, 7:08:19 AM
1class Solution {
2    public int reverseDegree(String s) {
3        int n = s.length();
4
5        int ans = 0;
6
7        for(int i = 0; i<n; i++){
8            int ch = 26 - (s.charAt(i) - 'a');
9            ans += ch*(i+1);
10        }
11
12        return ans;
13    }
14}