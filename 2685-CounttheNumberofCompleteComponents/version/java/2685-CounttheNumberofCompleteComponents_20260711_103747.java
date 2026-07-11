// Last updated: 7/11/2026, 10:37:47 AM
1class Solution {
2    public int countCompleteComponents(int n, int[][] edges) {
3        boolean[] visited = new boolean[n];
4
5        Map<Integer, List<Integer>> map = new HashMap<>();
6
7        for(int[] node : edges){
8            int u = node[0];
9            int v = node[1];
10
11            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
12            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
13        }
14
15        List<List<Integer>> connected = new ArrayList<>();
16
17        for(int i = 0; i<n; i++){
18            if(!visited[i]){
19                Queue<Integer> queue = new LinkedList<>();
20                queue.add(i);
21
22                List<Integer> subList = new ArrayList<>();
23                while(!queue.isEmpty()){
24                    int curr = queue.poll();
25                    if(visited[curr]) continue;
26
27                    subList.add(curr);
28
29                    List<Integer> list = map.getOrDefault(curr, new ArrayList<>());
30
31                    for(int j = 0; j<list.size(); j++){
32                        if(!visited[list.get(j)]){
33                            queue.add(list.get(j));
34                        }
35                    }
36
37                    visited[curr] = true;
38                }
39                connected.add(subList);
40            }
41        }
42
43        int count = 0;
44        int size = connected.size();
45        for(int i = 0; i<size; i++){
46            List<Integer> currList = connected.get(i);
47            if(isConnected(currList, map, currList.size())) count++;
48        }
49        
50        return count;
51    }
52
53    public boolean isConnected(List<Integer> currList, Map<Integer, List<Integer>> map, int size){
54        for(int j : currList){
55            if(map.getOrDefault(j, new ArrayList<>()).size() != size - 1)
56    return false;
57        }
58        return true;
59    }
60}