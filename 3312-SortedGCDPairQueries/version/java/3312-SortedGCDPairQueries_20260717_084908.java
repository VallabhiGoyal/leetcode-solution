// Last updated: 7/17/2026, 8:49:08 AM
1class Solution {
2    public int[] gcdValues(int[] nums, long[] queries) {
3        int max = 0;
4        for (int x : nums) max = Math.max(max, x);
5
6        int[] freq = new int[max + 1];
7        for (int x : nums) freq[x]++;
8
9        int[] divisible = new int[max + 1];
10
11        for (int i = 1; i <= max; i++) {
12            for (int j = i; j <= max; j += i) {
13                divisible[i] += freq[j];
14            }
15        }
16
17        long[] exact = new long[max + 1];
18
19        for (int i = max; i >= 1; i--) {
20            long cnt = divisible[i];
21            exact[i] = cnt * (cnt - 1) / 2;
22
23            for (int j = 2 * i; j <= max; j += i) {
24                exact[i] -= exact[j];
25            }
26        }
27
28        long[] prefix = new long[max + 1];
29        for (int i = 1; i <= max; i++) {
30            prefix[i] = prefix[i - 1] + exact[i];
31        }
32
33        int m = queries.length;
34        int[] ans = new int[m];
35
36        for (int i = 0; i < m; i++) {
37            long q = queries[i] + 1;
38
39            int l = 1, r = max;
40            while (l < r) {
41                int mid = l + (r - l) / 2;
42
43                if (prefix[mid] >= q) {
44                    r = mid;
45                } else {
46                    l = mid + 1;
47                }
48            }
49
50            ans[i] = l;
51        }
52
53        return ans;
54    }
55
56    public int gcd(int a, int b) {
57        while (b != 0) {
58            int temp = b;
59            b = a % b;
60            a = temp;
61        }
62        return a;
63    }
64}