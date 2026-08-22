// Last updated: 8/22/2026, 6:14:10 AM
1class Solution {
2    public boolean checkDivisibility(int n) {
3        int sum = 0;
4
5        int temp = n;
6        long prod = 1;
7
8        while(temp > 0){
9            int remain = temp % 10;
10            sum += remain;
11            prod *= remain;
12            temp /= 10;
13        }
14
15        prod += sum;
16
17        if(n % (int)prod == 0) return true;
18        return false;
19    }
20}