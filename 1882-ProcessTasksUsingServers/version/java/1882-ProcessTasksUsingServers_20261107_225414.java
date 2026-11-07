// Last updated: 11/7/2026, 10:54:14 PM
1class Solution {
2    public int[] assignTasks(int[] servers, int[] tasks) {
3        int n = servers.length;
4        int m = tasks.length;
5
6        int[] ans = new int[m];
7
8        PriorityQueue<int[]> availableServer = new PriorityQueue<>((a, b) -> {
9            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
10            return Integer.compare(a[1], b[1]);
11        });
12
13        for(int i = 0; i < n; i++){
14            availableServer.add(new int[]{servers[i], i});
15        }
16
17        PriorityQueue<int[]> busyServer = new PriorityQueue<>((a, b) -> {
18            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
19            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
20            return Integer.compare(a[2], b[2]);
21        });
22
23        long currTime = 0;
24
25        for(int i = 0; i < m; i++){
26            currTime = Math.max(currTime, i);
27
28            while(!busyServer.isEmpty() && busyServer.peek()[0] <= currTime){
29                int[] busy = busyServer.poll();
30                availableServer.add(new int[]{busy[1], busy[2]});
31            }
32
33            if(availableServer.isEmpty()){
34                currTime = busyServer.peek()[0];
35
36                while(!busyServer.isEmpty() && busyServer.peek()[0] <= currTime){
37                    int[] busy = busyServer.poll();
38                    availableServer.add(new int[]{busy[1], busy[2]});
39                }
40            }
41
42            int[] available = availableServer.poll();
43
44            ans[i] = available[1];
45
46            busyServer.add(new int[]{
47                (int)(currTime + tasks[i]),
48                available[0],
49                available[1]
50            });
51        }
52
53        return ans;
54    }
55}
56