// Last updated: 10/30/2026, 8:40:47 PM
1class Solution {
2    public int shortestPath(int n, int[][] edges, String labels, int k) {
3
4        List<int[]>[] adj = new ArrayList[n];
5
6        for (int i = 0; i < n; i++) {
7            adj[i] = new ArrayList<>();
8        }
9
10        for (int[] e : edges) {
11            adj[e[0]].add(new int[]{e[1], e[2]});
12        }
13
14        long[][] dist = new long[n][k + 1];
15
16        for (int i = 0; i < n; i++) {
17            Arrays.fill(dist[i], Long.MAX_VALUE);
18        }
19
20        PriorityQueue<long[]> pq = new PriorityQueue<>(
21            (a, b) -> Long.compare(a[0], b[0])
22        );
23
24        dist[0][1] = 0;
25        pq.offer(new long[]{0, 0, 1});
26
27        while (!pq.isEmpty()) {
28
29            long[] curr = pq.poll();
30
31            long d = curr[0];
32            int u = (int) curr[1];
33            int count = (int) curr[2];
34
35            if (d != dist[u][count]) continue;
36
37            if (u == n - 1) {
38                return (int) d;
39            }
40
41            for (int[] edge : adj[u]) {
42
43                int v = edge[0];
44                int wt = edge[1];
45
46                int newCount;
47
48                if (labels.charAt(u) == labels.charAt(v)) {
49                    newCount = count + 1;
50                } else {
51                    newCount = 1;
52                }
53
54                if (newCount > k) continue;
55
56                long newDist = d + wt;
57
58                if (newDist < dist[v][newCount]) {
59
60                    dist[v][newCount] = newDist;
61
62                    pq.offer(new long[]{
63                        newDist, v, newCount
64                    });
65                }
66            }
67        }
68
69        return -1;
70    }
71}