// Last updated: 7/11/2026, 10:39:52 AM
1class Solution {
2    public int countCompleteComponents(int n, int[][] edges) {
3        Map<Integer, List<Integer>> graph = new HashMap<>();
4
5        for (int[] edge : edges) {
6            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
7            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
8        }
9
10        boolean[] visited = new boolean[n];
11        int count = 0;
12
13        for (int i = 0; i < n; i++) {
14            if (visited[i]) continue;
15
16            List<Integer> component = new ArrayList<>();
17            Queue<Integer> queue = new LinkedList<>();
18            queue.offer(i);
19
20            while (!queue.isEmpty()) {
21                int curr = queue.poll();
22
23                if (visited[curr]) continue;
24                visited[curr] = true;
25
26                component.add(curr);
27
28                for (int next : graph.getOrDefault(curr, Collections.emptyList())) {
29                    if (!visited[next]) {
30                        queue.offer(next);
31                    }
32                }
33            }
34
35            if (isComplete(component, graph)) {
36                count++;
37            }
38        }
39
40        return count;
41    }
42
43    private boolean isComplete(List<Integer> component, Map<Integer, List<Integer>> graph) {
44        int size = component.size();
45
46        for (int node : component) {
47            if (graph.getOrDefault(node, Collections.emptyList()).size() != size - 1) {
48                return false;
49            }
50        }
51
52        return true;
53    }
54}