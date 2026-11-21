// Last updated: 11/21/2026, 4:28:27 PM
1class Solution {
2    public int[] findSubtreeSizes(int[] parent, String s) {
3        int n = parent.length;
4
5        List<Integer>[] adj = new ArrayList[n];
6
7        for (int i = 0; i < n; i++) {
8            adj[i] = new ArrayList<>();
9        }
10
11        for (int i = 1; i < n; i++) {
12            adj[parent[i]].add(i);
13        }
14
15        int[] newParent = new int[n];
16        Arrays.fill(newParent, -1);
17
18        int[] last = new int[26];
19        Arrays.fill(last, -1);
20
21        dfs(0, adj, s, last, newParent, parent);
22
23        List<Integer>[] tree = new ArrayList[n];
24
25        for (int i = 0; i < n; i++) {
26            tree[i] = new ArrayList<>();
27        }
28
29        for (int i = 1; i < n; i++) {
30            tree[newParent[i]].add(i);
31        }
32
33        int[] ans = new int[n];
34
35        calculate(0, tree, ans);
36
37        return ans;
38    }
39
40    void dfs(int node, List<Integer>[] adj, String s,
41             int[] last, int[] newParent, int[] parent) {
42
43        int ch = s.charAt(node) - 'a';
44
45        int previous = last[ch];
46
47        newParent[node] = (previous == -1) ? parent[node] : previous;
48        
49        last[ch] = node;
50
51        for (int child : adj[node]) {
52            dfs(child, adj, s, last, newParent, parent);
53        }
54
55        last[ch] = previous;
56    }
57
58    int calculate(int node, List<Integer>[] tree, int[] ans) {
59        int size = 1;
60
61        for (int child : tree[node]) {
62            size += calculate(child, tree, ans);
63        }
64
65        ans[node] = size;
66
67        return size;
68    }
69}