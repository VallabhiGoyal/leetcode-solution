// Last updated: 11/9/2026, 10:40:19 PM
1class Solution {
2    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
3        TreeSet<Integer> available = new TreeSet<>();
4
5        for(int i = 0; i < k; i++){
6            available.add(i);
7        }
8
9        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> 
10            Integer.compare(a[0], b[0])
11        );
12
13        int[] count = new int[k];
14
15        for(int i = 0; i < arrival.length; i++){
16
17            while(!busy.isEmpty() && busy.peek()[0] <= arrival[i]){
18                int[] curr = busy.poll();
19                available.add(curr[1]);
20            }
21
22            if(available.isEmpty()){
23                continue;
24            }
25
26            int server = i % k;
27
28            Integer assigned = available.ceiling(server);
29
30            if(assigned == null){
31                assigned = available.first();
32            }
33
34            available.remove(assigned);
35
36            count[assigned]++;
37
38            busy.add(new int[]{
39                arrival[i] + load[i],
40                assigned
41            });
42        }
43
44        int max = 0;
45
46        for(int x : count){
47            max = Math.max(max, x);
48        }
49
50        List<Integer> ans = new ArrayList<>();
51
52        for(int i = 0; i < k; i++){
53            if(count[i] == max){
54                ans.add(i);
55            }
56        }
57
58        return ans;
59    }
60}