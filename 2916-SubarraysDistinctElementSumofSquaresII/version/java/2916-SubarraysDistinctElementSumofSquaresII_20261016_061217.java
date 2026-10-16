// Last updated: 10/16/2026, 6:12:17 AM
1class Solution {
2    static final long MOD = 1000000007L;
3
4    public int sumCounts(int[] nums) {
5        int n = nums.length;
6        int[] last = new int[100001];
7        java.util.Arrays.fill(last, -1);
8
9        SegmentTree tree = new SegmentTree(n);
10        long answer = 0;
11
12        for (int i = 0; i < n; i++) {
13            tree.update(last[nums[i]] + 1, i);
14            last[nums[i]] = i;
15            answer = (answer + tree.square[1]) % MOD;
16        }
17
18        return (int) answer;
19    }
20
21    class SegmentTree {
22        long[] sum, square, lazy;
23        int n;
24
25        SegmentTree(int n) {
26            this.n = n;
27            sum = new long[4 * n];
28            square = new long[4 * n];
29            lazy = new long[4 * n];
30        }
31
32        void apply(int node, int l, int r, long val) {
33            long len = r - l + 1L;
34
35            square[node] = (square[node]
36                    + 2 * val % MOD * sum[node] % MOD
37                    + len % MOD * val % MOD * val % MOD) % MOD;
38
39            sum[node] = (sum[node] + len % MOD * val % MOD) % MOD;
40            lazy[node] = (lazy[node] + val) % MOD;
41        }
42
43        void push(int node, int l, int r) {
44            if (lazy[node] == 0 || l == r) return;
45
46            int mid = (l + r) / 2;
47
48            apply(node * 2, l, mid, lazy[node]);
49            apply(node * 2 + 1, mid + 1, r, lazy[node]);
50
51            lazy[node] = 0;
52        }
53
54        void update(int node, int l, int r, int ql, int qr) {
55            if (ql > r || qr < l) return;
56
57            if (ql <= l && r <= qr) {
58                apply(node, l, r, 1);
59                return;
60            }
61
62            push(node, l, r);
63
64            int mid = (l + r) / 2;
65
66            update(node * 2, l, mid, ql, qr);
67            update(node * 2 + 1, mid + 1, r, ql, qr);
68
69            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
70            square[node] = (square[node * 2] + square[node * 2 + 1]) % MOD;
71        }
72
73        void update(int l, int r) {
74            if (l <= r) update(1, 0, n - 1, l, r);
75        }
76    }
77}