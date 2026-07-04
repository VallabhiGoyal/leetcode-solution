// Last updated: 7/4/2026, 7:47:30 AM
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
20
21        while(!stack.isEmpty()){
22            int curr = stack.pop();
23            visited[curr] = true;
24            List<Node> edges = map.get(curr);
25
26            int size = edges.size();
27            for(Node node : edges){
28                if(!visited[node.v]){
29                    stack.push(node.v);
30                    minDist = Math.min(minDist, node.wt);
31                }
32            }
33        }
34
35        return minDist;
36    }
37
38    public class Node{
39        int v;
40        int wt;
41
42        Node(int v, int wt){
43            this.v = v;
44            this.wt = wt;
45        }
46    }
47}