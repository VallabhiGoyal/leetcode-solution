// Last updated: 10/18/2026, 9:05:46 AM
1class Solution {
2    public int findColoredRoot(int[][] edges, String colors) {
3        int n = colors.length();
4        int m = edges.length;
5
6        int [] parents = new int[n];
7        
8        Map<Integer, List<Integer>> map = new HashMap<>();
9
10        for(int i = 0; i<m; i++){
11            int u = edges[i][0];
12            int v = edges[i][1];
13
14            char cU = colors.charAt(u);
15            char cV = colors.charAt(v);
16
17            if(cU == cV) return -1;
18
19            if((cU == 'R' && cV == 'B') || (cU == 'B' && cV == 'W') || (cU == 'W' && cV == 'R')){
20                map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
21                if(map.get(u).size() > 2) return -1;
22                parents[v]++;
23            }
24            
25            if((cV == 'R' && cU == 'B') || (cV == 'B' && cU == 'W') || (cV == 'W' && cU == 'R')){
26                map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
27                if(map.get(v).size() > 2) return -1;
28                parents[u]++;
29            }
30        }
31
32        int zeroParent = 0;
33        int rootIdx = -1;
34
35        for(int i = 0; i<n; i++){
36            if(parents[i] == 0){
37                zeroParent++;
38                rootIdx = i;
39            }
40
41            if(zeroParent > 1) return -1;
42        }
43
44        if(rootIdx == -1) return -1;
45
46        return rootIdx;
47    }
48}