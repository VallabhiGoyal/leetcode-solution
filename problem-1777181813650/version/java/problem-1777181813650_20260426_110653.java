// Last updated: 4/26/2026, 11:06:53 AM
/*
 * Approach
 *     Generate all subsets using bitmask
 *     For each subset:
 *         Check even sum
 *         Use DFS to check connectivity (only within subset)
 *     Count valid subsets
 * 
 * Time Complexity
 *     O(2^n * (n + E))
 * 
 * Space Complexity
 *     O(n + E)
 * 
 * Pattern
 *     Bitmask + Graph DFS
*/

1class Solution {
2    public int evenSumSubgraphs(int[] nums, int[][] edges) {
3        int totalNodes = nums.length;
4        int totalEdges = edges.length;
5
6        List<Integer>[] adj = new ArrayList[totalNodes];
7        for(int i = 0; i<totalNodes; i++){
8            adj[i] = new ArrayList<>();
9        }
10        
11        for(int i = 0; i<totalEdges; i++){
12            int u = edges[i][0];
13            int v = edges[i][1];
14
15            List<Integer> list1 = adj[u];
16            list1.add(v);
17
18            List<Integer> list2 = adj[v];
19            list2.add(u);
20        }
21
22        int totalSubset = 1 << totalNodes;
23        int count  = 0;
24
25        for(int mask = 0; mask < totalSubset; mask++){
26            if(mask == 0) continue;
27
28            int sum = 0;
29            for(int i = 0; i<totalNodes; i++){
30                if((mask & (1<<i)) != 0){
31                    sum += nums[i];
32                }
33            }
34            if(sum % 2 != 0) continue;
35
36            int start = -1;
37            for(int i = 0; i<totalNodes; i++){
38                if((mask & (1 << i)) != 0){
39                    start = i;
40                    break;
41                }
42            }
43
44            boolean[] visited = new boolean[totalNodes];
45            Stack<Integer> stack = new Stack<>();
46            stack.push(start);
47            visited[start] = true;
48
49            int visitedCount = 0;
50            
51            while(!stack.isEmpty()){
52                int u = stack.pop();
53                visitedCount++;
54
55                for(int v : adj[u]){
56                    if((mask & (1<<v)) != 0 && !visited[v]){
57                        visited[v] = true;
58                        stack.push(v);
59                    }
60                }
61            }
62
63            int size = Integer.bitCount(mask);
64
65            if(visitedCount == size) count++;
66            
67        }
68
69        return count;
70    }
71}