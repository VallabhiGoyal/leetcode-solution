// Last updated: 8/6/2026, 6:09:57 AM
1class Solution {
2    public int smallestNumber(int n, int t) {
3        while (true) {
4            long prod = 1;
5            int temp = n;
6
7            while (temp > 0) {
8                prod *= (temp % 10);
9                temp /= 10;
10            }
11
12            if (n == 0) prod = 0;
13
14            if (prod % t == 0) {
15                return n;
16            }
17            n++;
18        }
19    }
20}