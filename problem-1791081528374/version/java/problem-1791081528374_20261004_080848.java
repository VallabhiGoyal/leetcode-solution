// Last updated: 10/4/2026, 8:08:48 AM
1class Solution {
2    public int minRotations(String s) {
3        int ans = 0;
4        int prev = 0;
5        for(int i = 0; i<10; i++){
6            int num = s.charAt(i) - '0';
7            int diff = Math.abs(num - prev);
8            
9            ans += Math.min(diff, 10 - diff);
10
11            prev = num;
12        }
13
14        return ans;
15    }
16}