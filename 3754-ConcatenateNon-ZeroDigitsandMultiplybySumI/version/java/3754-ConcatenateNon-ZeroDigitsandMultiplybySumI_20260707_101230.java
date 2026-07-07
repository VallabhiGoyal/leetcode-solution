// Last updated: 7/7/2026, 10:12:30 AM
1class Solution {
2    public long sumAndMultiply(int n) {
3        if(n == 0) return 0;
4        
5        StringBuilder x = new StringBuilder();
6        long sum = 0;
7
8        while(n > 0){
9            int remain = n % 10;
10            if(remain != 0){
11                sum += remain;
12                x.insert(0, remain);
13            }
14            n /= 10;
15        }
16
17        long mul = Long.valueOf(x.toString());
18        return sum*(long)mul;
19    }
20}