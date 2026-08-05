// Last updated: 8/5/2026, 6:23:15 AM
1class Solution {
2    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
3        int m = invocations.length;
4
5        Map<Integer, List<Integer>> map = new HashMap<>();
6
7        for(int i = 0; i<m; i++){
8            int u = invocations[i][0];
9            int v = invocations[i][1];
10
11            map.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
12        }
13
14        boolean[] visited = new boolean[n];
15
16        Stack<Integer> stack = new Stack<>();
17        stack.push(k);
18
19        while(!stack.isEmpty()){
20            int curr = stack.pop();
21
22            if(visited[curr]) continue;
23            visited[curr] = true;
24
25            if(!map.containsKey(curr)) continue;
26
27            List<Integer> list = map.get(curr);
28
29            int size = list.size();
30            for(int i = 0; i<size; i++){
31                stack.push(list.get(i));
32            }
33        }
34
35        boolean flag = false;
36        for (int[] edge : invocations) {
37            if (!visited[edge[0]] && visited[edge[1]]) {
38                flag = true;
39                break;
40            }
41        }
42
43        List<Integer> ans = new ArrayList<>();
44        if(!flag){
45            for(int i = 0; i<n; i++){
46                if(!visited[i]){
47                    ans.add(i);
48                }
49            }
50        }else{
51            for(int i = 0; i<n; i++){
52                ans.add(i);
53            }
54        }
55
56        return ans;
57    }
58}