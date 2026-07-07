// Last updated: 7/7/2026, 10:13:57 AM
1class Solution {
2    public long sumAndMultiply(int n) {
3        if(n == 0) return 0;
4
5        int x = 0;
6        long sum = 0;
7
8        while(n > 0){
9            int remain = n % 10;
10            if(remain != 0){
11                sum += remain;
12                x = 10*x + remain;
13            }
14            n /= 10;
15        }
16
17        long ans = 0;
18        while(x != 0){
19            ans = ans*10 + x%10;
20            x /= 10;
21        }
22
23        return sum*ans;
24    }
25}