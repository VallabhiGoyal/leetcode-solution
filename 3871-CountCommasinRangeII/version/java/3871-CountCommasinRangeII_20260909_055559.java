// Last updated: 9/9/2026, 5:55:59 AM
1class Solution {
2    public long countCommas(long n) {
3        long temp = n;
4        long count = 0;
5
6        long start = 1000;
7        int commas = 1;
8
9        while (start <= temp) {
10            long end = start * 1000 - 1;
11            long upper = Math.min(temp, end);
12
13            count += (upper - start + 1) * commas;
14
15            start *= 1000;
16            commas++;
17        }
18
19        return count;
20    }
21}