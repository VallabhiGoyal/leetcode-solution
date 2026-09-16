// Last updated: 9/16/2026, 7:15:33 AM
1class Solution {
2    public int numberOfSets(int n, int k) {
3        long MOD = 1000000007L;
4
5        int N = n + k - 1;
6
7        long[] fact = new long[N + 1];
8        long[] invFact = new long[N + 1];
9
10        fact[0] = 1;
11
12        for (int i = 1; i <= N; i++) {
13            fact[i] = fact[i - 1] * i % MOD;
14        }
15
16        invFact[N] = power(fact[N], MOD - 2, MOD);
17
18        for (int i = N - 1; i >= 0; i--) {
19            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
20        }
21
22        long ans = fact[N];
23
24        ans = ans * invFact[2 * k] % MOD;
25        ans = ans * invFact[N - 2 * k] % MOD;
26
27        return (int) ans;
28    }
29
30    private long power(long a, long b, long MOD) {
31        long result = 1;
32
33        while (b > 0) {
34            if ((b & 1) == 1) {
35                result = result * a % MOD;
36            }
37
38            a = a * a % MOD;
39            b >>= 1;
40        }
41
42        return result;
43    }
44}