// Last updated: 9/6/2026, 8:33:47 AM
1class Solution {
2    public int countRotations(String s, int k) {
3        int n = s.length();
4
5        int count = 0;
6
7        for(int i = 0; i<n; i++){
8            int base = 0;
9            for(int j = 0; j<n-1; j++){
10                char ch1 = s.charAt((i+j)%n);
11                char ch2 = s.charAt((i+j+1)%n);
12
13                if(ch1 == ch2) base++;
14            }
15
16            if(base == k) count++;
17        }
18
19        return count;
20    }
21}