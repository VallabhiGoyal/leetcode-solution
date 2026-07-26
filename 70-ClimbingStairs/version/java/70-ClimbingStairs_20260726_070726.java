// Last updated: 7/26/2026, 7:07:26 AM
1class Solution {
2    public int climbStairs(int n) {
3        if(n == 1) return 1;
4        if(n == 2) return 2;
5        int n1 = 1;
6        int n2 = 2;
7        int ans = 0;
8        for(int i = 3; i<=n; i++){
9            ans = n1+ n2;
10            n1 = n2;
11            n2 = ans;
12        }
13
14        return ans;
15    }
16}