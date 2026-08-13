// Last updated: 8/13/2026, 2:34:15 PM
1class Solution {
2    Node[] tree;
3
4    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
5        int k = queryIndices.length;
6        int n = s.length();
7
8        char[] ch = s.toCharArray();
9        tree = new Node[4 * n];
10
11        build(1, 0, n - 1, ch);
12
13        int[] ans = new int[k];
14
15        for (int i = 0; i < k; i++) {
16            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
17            ans[i] = tree[1].maxLen;
18        }
19
20        return ans;
21    }
22
23    public void build(int node, int left, int right, char[] ch) {
24        if (left == right) {
25            tree[node] = new Node(ch[left], ch[left], 1, 1, 1, 1);
26            return;
27        }
28
29        int mid = left + (right - left) / 2;
30
31        build(2 * node, left, mid, ch);
32        build(2 * node + 1, mid + 1, right, ch);
33
34        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
35    }
36
37    public void update(int node, int left, int right, int idx, char newChar) {
38        if (left == right) {
39            tree[node] = new Node(newChar, newChar, 1, 1, 1, 1);
40            return;
41        }
42
43        int mid = left + (right - left) / 2;
44
45        if (idx <= mid) {
46            update(2 * node, left, mid, idx, newChar);
47        } else {
48            update(2 * node + 1, mid + 1, right, idx, newChar);
49        }
50
51        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
52    }
53
54    public Node merge(Node left, Node right) {
55        int prefixLen = left.prefixLen;
56        int suffixLen = right.suffixLen;
57        int maxLen = Math.max(left.maxLen, right.maxLen);
58
59        if (left.lastChar == right.firstChar) {
60
61            if (left.prefixLen == left.totalLen) {
62                prefixLen = left.totalLen + right.prefixLen;
63            }
64
65            if (right.suffixLen == right.totalLen) {
66                suffixLen = left.suffixLen + right.totalLen;
67            }
68
69            maxLen = Math.max(maxLen,
70                    left.suffixLen + right.prefixLen);
71        }
72
73        return new Node(
74                left.firstChar,
75                right.lastChar,
76                prefixLen,
77                suffixLen,
78                maxLen,
79                left.totalLen + right.totalLen
80        );
81    }
82
83    class Node {
84        char firstChar;
85        char lastChar;
86        int prefixLen;
87        int suffixLen;
88        int maxLen;
89        int totalLen;
90
91        Node(char firstChar, char lastChar,
92             int prefixLen, int suffixLen,
93             int maxLen, int totalLen) {
94
95            this.firstChar = firstChar;
96            this.lastChar = lastChar;
97            this.prefixLen = prefixLen;
98            this.suffixLen = suffixLen;
99            this.maxLen = maxLen;
100            this.totalLen = totalLen;
101        }
102    }
103}