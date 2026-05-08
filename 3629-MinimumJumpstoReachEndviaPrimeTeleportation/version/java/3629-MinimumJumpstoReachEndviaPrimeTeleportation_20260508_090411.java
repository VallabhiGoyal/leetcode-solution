// Last updated: 5/8/2026, 9:04:11 AM
1class Solution {
2    public int minJumps(int[] nums) {
3        int n = nums.length;
4        Map<Integer, List<Integer>> map = new HashMap<>();
5
6        for(int i = 0; i<n; i++){
7            if(isPrime(nums[i])){
8                map.put(nums[i], map.getOrDefault(nums[i], new ArrayList<>()));
9                map.get(nums[i]).add(i);
10            }
11        }
12
13        for(int i = 0; i<n; i++){
14            if(isPrime(nums[i])) continue;
15            List<Integer> list = primeFactors(nums[i]);
16
17            int size = list.size();
18            for(int j = 0; j<size; j++){
19                if(map.containsKey(list.get(j))){
20                    map.get(list.get(j)).add(i);
21                }
22            }
23        }
24
25        Queue<Integer> q = new LinkedList<>();
26        q.add(0);
27
28        boolean[] visited = new boolean[n];
29        visited[0] = true;
30
31        int steps = 0;
32        while(!q.isEmpty()){
33            int size = q.size();
34
35            for(int i = 0; i<size; i++){
36                int idx = q.poll();
37
38                if(idx == n-1) return steps;
39
40                if(idx+1 < n && !visited[idx+1]){
41                    visited[idx+1] = true;
42                    q.add(idx+1);
43                }
44                if(idx-1 >=0 && !visited[idx-1]){
45                    visited[idx-1] = true;
46                    q.add(idx-1);
47                }
48
49                if (isPrime(nums[idx])) {
50
51                    List<Integer> list = map.get(nums[idx]);
52
53                    if (list != null) {
54
55                        for (int next : list) {
56
57                            if (!visited[next]) {
58                                visited[next] = true;
59                                q.add(next);
60                            }
61                        }
62
63                        map.remove(nums[idx]);
64                    }
65                }
66
67            }
68            steps++;
69        }
70
71        return steps;
72    }
73
74    private List<Integer> primeFactors(int n){
75        List<Integer> list = new ArrayList<>();
76        if(n == 1) return list;
77        for(int i = 2; i*i<=n; i++){
78            if(n%i == 0){
79                if(isPrime(i)) list.add(i);
80                while(n%i == 0) n/=i;
81            }
82        }
83        if(n > 1) list.add(n);
84        return list;
85    }
86
87    private boolean isPrime(int n){
88        if(n == 1) return false;
89        if(n == 2) return true;
90        for(int i = 2; i*i<=n; i++){
91            if(n%i == 0) return false;
92        }
93        return true;
94    }
95}