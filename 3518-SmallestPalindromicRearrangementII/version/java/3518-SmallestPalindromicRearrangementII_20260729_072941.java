// Last updated: 7/29/2026, 7:29:41 AM
1class Solution {
2    public String smallestPalindrome(String s, int k) {
3        int n = s.length();
4
5        int[] freq = new int[26];
6        int mid = -1;
7
8        for (char c : s.toCharArray()) {
9            freq[c - 'a']++;
10        }
11
12        for (int i = 0; i < 26; i++) {
13            if ((freq[i] & 1) == 1) {
14                mid = i;
15            }
16            freq[i] /= 2;
17        }
18
19        int half = n / 2;
20
21        if (countPermutations(freq, half, k) < k) {
22            return "";
23        }
24
25        StringBuilder left = new StringBuilder();
26
27        for (int pos = 0; pos < half; pos++) {
28            for (int c = 0; c < 26; c++) {
29                if (freq[c] == 0) continue;
30
31                freq[c]--;
32
33                long cnt = countPermutations(freq, half - pos - 1, k);
34
35                if (cnt >= k) {
36                    left.append((char) ('a' + c));
37                    break;
38                } else {
39                    k -= cnt;
40                    freq[c]++;
41                }
42            }
43        }
44
45        StringBuilder ans = new StringBuilder();
46        ans.append(left);
47
48        if (mid != -1) {
49            ans.append((char) ('a' + mid));
50        }
51
52        ans.append(new StringBuilder(left).reverse());
53
54        return ans.toString();
55    }
56
57    private long countPermutations(int[] freq, int len, int limit) {
58        long ans = 1;
59        int remaining = len;
60
61        for (int f : freq) {
62            if (f == 0) continue;
63
64            ans *= nCrLimited(remaining, f, limit);
65            if (ans > limit) return limit;
66
67            remaining -= f;
68        }
69
70        return Math.min(ans, (long) limit);
71    }
72
73    private long nCrLimited(int n, int r, int limit) {
74        r = Math.min(r, n - r);
75
76        long res = 1;
77
78        for (int i = 1; i <= r; i++) {
79            res = res * (n - r + i) / i;
80            if (res > limit) return limit;
81        }
82
83        return res;
84    }
85}