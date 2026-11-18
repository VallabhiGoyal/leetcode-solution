// Last updated: 11/18/2026, 4:37:41 PM
1class Solution {
2    public int minChanges(String s) {
3        int ans = 0;
4
5        for (int i = 0; i < s.length(); i += 2) {
6            if (s.charAt(i) != s.charAt(i + 1)) {
7                ans++;
8            }
9        }
10
11        return ans;
12    }
13}