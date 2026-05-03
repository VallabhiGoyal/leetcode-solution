// Last updated: 5/3/2026, 7:12:10 AM
1class Solution {
2    public int myAtoi(String s) {
3        int n = s.length();
4
5        int idx = 0;
6        while(idx < n && s.charAt(idx) == ' ') idx++;
7
8        int sign = 1;
9        if(idx < n && (s.charAt(idx) == '-' || s.charAt(idx) == '+')){
10            if(s.charAt(idx) == '-') sign = -1;
11            idx++;
12        }
13
14        long ans = 0;
15
16        while(idx < n && s.charAt(idx) >= '0' && s.charAt(idx) <= '9'){
17            ans = ans*10 + (s.charAt(idx) - '0');
18
19            if(sign*ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
20
21            if(sign*ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
22
23            idx++; 
24        }
25
26        return (int)(sign*ans);
27    }
28}