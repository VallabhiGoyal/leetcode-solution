// Last updated: 10/30/2026, 6:55:33 AM
1class Solution {
2    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
3        List<Integer>[] adj = new ArrayList[n];
4        for (int i = 0; i < n; i++) {
5            adj[i] = new ArrayList<>();
6        }
7
8        for (int[] edge : edges) {
9            adj[edge[0]].add(edge[1]);
10            adj[edge[1]].add(edge[0]);
11        }
12
13        int log = 1;
14        while ((1 << log) <= n) {
15            log++;
16        }
17
18        int[][] up = new int[log][n];
19        int[] parent = new int[n];
20        int[] depth = new int[n];
21        int[] tin = new int[n];
22        int[] tout = new int[n];
23        int[] pref = new int[n];
24        int[] size = new int[n];
25        char[] chars = s.toCharArray();
26
27        Arrays.fill(parent, -1);
28
29        int[] stack = new int[n];
30        int[] order = new int[n];
31        int top = 0, timer = 0, count = 0;
32
33        stack[top++] = 0;
34        parent[0] = 0;
35        pref[0] = 1 << (chars[0] - 'a');
36
37        while (top > 0) {
38            int u = stack[--top];
39
40            tin[u] = timer++;
41            order[count++] = u;
42            size[u] = 1;
43
44            for (int v : adj[u]) {
45                if (v == parent[u]) {
46                    continue;
47                }
48
49                parent[v] = u;
50                depth[v] = depth[u] + 1;
51                pref[v] = pref[u] ^ (1 << (chars[v] - 'a'));
52                up[0][v] = u;
53                stack[top++] = v;
54            }
55        }
56
57        up[0][0] = 0;
58
59        for (int k = 1; k < log; k++) {
60            for (int i = 0; i < n; i++) {
61                up[k][i] = up[k - 1][up[k - 1][i]];
62            }
63        }
64
65        for (int i = n - 1; i >= 0; i--) {
66            int u = order[i];
67            if (u != 0) {
68                size[parent[u]] += size[u];
69            }
70            tout[u] = tin[u] + size[u] - 1;
71        }
72
73        Fenwick bit = new Fenwick(n + 1);
74        List<Boolean> ans = new ArrayList<>();
75
76        for (String q : queries) {
77            String[] parts = q.split(" ");
78            int u = Integer.parseInt(parts[1]);
79
80            if (parts[0].equals("update")) {
81                char c = parts[2].charAt(0);
82
83                int delta = (1 << (chars[u] - 'a')) ^ (1 << (c - 'a'));
84
85                bit.update(tin[u] + 1, delta);
86                bit.update(tout[u] + 2, delta);
87
88                chars[u] = c;
89            } else {
90                int v = Integer.parseInt(parts[2]);
91                int lca = getLCA(u, v, depth, up, log);
92
93                int maskU = pref[u] ^ bit.query(tin[u] + 1);
94                int maskV = pref[v] ^ bit.query(tin[v] + 1);
95
96                int mask = maskU ^ maskV ^ (1 << (chars[lca] - 'a'));
97
98                ans.add((mask & (mask - 1)) == 0);
99            }
100        }
101
102        return ans;
103    }
104
105    private int getLCA(int u, int v, int[] depth, int[][] up, int log) {
106        if (depth[u] < depth[v]) {
107            int temp = u;
108            u = v;
109            v = temp;
110        }
111
112        int diff = depth[u] - depth[v];
113
114        for (int k = 0; k < log; k++) {
115            if ((diff & (1 << k)) != 0) {
116                u = up[k][u];
117            }
118        }
119
120        if (u == v) {
121            return u;
122        }
123
124        for (int k = log - 1; k >= 0; k--) {
125            if (up[k][u] != up[k][v]) {
126                u = up[k][u];
127                v = up[k][v];
128            }
129        }
130
131        return up[0][u];
132    }
133
134    static class Fenwick {
135        int[] tree;
136
137        Fenwick(int n) {
138            tree = new int[n + 1];
139        }
140
141        void update(int i, int val) {
142            while (i < tree.length) {
143                tree[i] ^= val;
144                i += i & -i;
145            }
146        }
147
148        int query(int i) {
149            int res = 0;
150
151            while (i > 0) {
152                res ^= tree[i];
153                i -= i & -i;
154            }
155
156            return res;
157        }
158    }
159}
160