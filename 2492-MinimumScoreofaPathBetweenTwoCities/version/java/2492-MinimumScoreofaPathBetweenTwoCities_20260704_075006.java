// Last updated: 7/4/2026, 7:50:06 AM
1class Solution {
2    public int minScore(int n, int[][] roads) {
3
4        Map<Integer, List<Node>> map = new HashMap<>();
5
6        for(int[] edge : roads){
7            int u = edge[0];
8            int v = edge[1];
9            int wt = edge[2];
10
11            map.computeIfAbsent(u, k -> new ArrayList<>()).add(new Node(v, wt));
12            map.computeIfAbsent(v, k -> new ArrayList<>()).add(new Node(u, wt));
13        }
14
15        int minDist = Integer.MAX_VALUE;
16
17        boolean[] visited = new boolean[n+1];
18        Stack<Integer> stack = new Stack<>();
19        stack.push(1);
20        visited[1] = true;
21
22        while(!stack.isEmpty()){
23            int curr = stack.pop();
24            List<Node> edges = map.get(curr);
25
26            int size = edges.size();
27            for(Node node : edges){
28                minDist = Math.min(minDist, node.wt);
29
30                if(!visited[node.v]){
31                    visited[node.v] = true;
32                    stack.push(node.v);
33                }
34            }
35        }
36
37        return minDist;
38    }
39
40    public class Node{
41        int v;
42        int wt;
43
44        Node(int v, int wt){
45            this.v = v;
46            this.wt = wt;
47        }
48    }
49}