// Last updated: 8/1/2026, 8:05:45 PM
1class Solution {
2    public int countValidPrefixes(String s) {
3        int n = s.length();
4
5        int prefixOne = 0;
6        int prefixZero = 0;
7        int count = 0;
8        for(int i = 0; i<n; i++){
9            int ch = s.charAt(i) - '0';
10
11            if(ch == 1) prefixOne++;
12            else prefixZero++;
13            
14            if(Math.abs(prefixOne - prefixZero) <= 1) count++; 
15        }
16
17        return count;
18    }
19}