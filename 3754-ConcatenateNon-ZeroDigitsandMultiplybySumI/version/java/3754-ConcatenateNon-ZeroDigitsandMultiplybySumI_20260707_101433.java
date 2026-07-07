// Last updated: 7/7/2026, 10:14:33 AM
1class Solution {
2    public long sumAndMultiply(int n) {
3        int x=0;
4        int sum=0;
5        int i=1;
6        while(n>0){
7            int m=n % 10;
8            n /=10;
9            if(m == 0) continue;
10            sum += m;
11            x += (m * i);
12            i *=10;
13        }
14        return (long) x * sum;
15    }
16}