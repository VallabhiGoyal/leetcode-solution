// Last updated: 7/15/2026, 6:16:19 AM
1class Solution {
2    public int gcdOfOddEvenSums(int n) {
3        long sumOdd = n*n;
4        long sumEven = n*(n + 1);
5
6        return gcd(sumOdd, sumEven);
7    }
8
9    public int gcd(long a, long b){
10        while(b != 0){
11            long temp = b;
12            b = a%b;
13            a = temp;
14        }
15
16        return (int)a;
17    }
18}