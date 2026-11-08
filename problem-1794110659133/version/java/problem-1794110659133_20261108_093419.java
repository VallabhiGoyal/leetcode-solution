// Last updated: 11/8/2026, 9:34:19 AM
1class Solution {
2    long[] dp;
3    Map<Integer, List<Integer>> map;
4    long maxGain = 0;
5    long totalCost = 0;
6    
7    public long minCost(int n, String colors, int[][] edges) {
8        int m = edges.length;
9        
10        map = new HashMap<>();
11        for(int i = 0; i<m; i++){
12            int u = edges[i][0];
13            int v = edges[i][1];
14
15            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
16            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
17        }
18
19        int red = 0;
20        for(int i = 0; i<n; i++){
21            if(colors.charAt(i) == 'R') red++;
22        }
23        if(red == 0 || red == n) return 0;
24
25        dp = new long[n];
26        cost(0, -1);
27
28        totalCost = 0;
29        for(int i = 0; i<n; i++){
30            if(colors.charAt(i) == 'R'){
31                totalCost += dp[i];
32            }
33        }
34
35        maxGain = Long.MIN_VALUE;
36        helper(0, -1, colors);
37
38        return totalCost - maxGain;
39    }
40
41    public long cost(int u, int parent){
42        long size = 1;
43
44        for(int v : map.get(u)){
45            if(v == parent) continue;
46            size += cost(v, u);
47        }
48
49        dp[u] = size;
50        return size;
51    }
52
53    public long helper(int u, int parent, String colors){
54        long gain = 0;
55        if(colors.charAt(u) == 'R'){
56            gain = dp[u];
57        }else{
58            gain = -dp[u];
59        }
60
61        for(int v : map.get(u)){
62            if(v == parent) continue;
63
64            gain += Math.max(0, helper(v, u, colors));
65        }
66
67        maxGain = Math.max(maxGain, gain);
68
69        return gain;
70    }
71}