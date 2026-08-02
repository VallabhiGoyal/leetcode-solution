// Last updated: 8/2/2026, 9:14:28 AM
1class Solution {
2    public int[] countTasks(int[] tasks, int[] shifts) {
3        int n = tasks.length;
4        int m = shifts.length;
5
6        long[] prefix = new long[n];
7        prefix[0] = tasks[0];
8        for(int i = 1; i<n; i++){
9            prefix[i] = prefix[i-1] + tasks[i];
10        }
11
12        int[] ans = new int[m];
13        long currPending = tasks[0];
14        int idx = 0;
15        
16        for(int i = 0; i<m; i++){
17
18            long remaining = currPending;
19            if(idx < n-1){
20                remaining += prefix[n-1] - prefix[idx];    
21            }
22            
23            if(remaining <= shifts[i]){
24                ans[i] = 0;
25                currPending = tasks[0];
26                idx = 0;
27                continue;
28            }
29
30            long time = shifts[i];
31            
32            if(time < currPending){
33                currPending -= shifts[i];
34                ans[i] = n - idx;
35                continue;
36            }
37
38            time -= currPending;
39            idx++;
40
41            if(idx == n){
42                ans[i] = 0;
43                currPending = tasks[0];
44                idx = 0;
45                continue;
46            }
47
48            long target = prefix[idx-1] + time;
49
50            int j = binarySearch(prefix, target, idx);
51
52            if(j >= idx) idx = j+1;
53
54            if(idx == n){
55                ans[i] = 0;
56                currPending = tasks[0];
57                idx = 0;
58                continue;
59            }else{
60                long completed;
61                if(idx == 0) completed = 0;
62                else completed = prefix[idx-1];
63
64                currPending = tasks[idx] - (target - completed);
65                ans[i] = n-idx;
66            }
67        }
68
69        return ans;
70    }
71
72    public static int binarySearch(long[] prefix, long target, int idx){
73        int n = prefix.length;
74
75        int low = idx;
76        int high = n-1;
77        int ans = idx - 1;
78        
79        while(low <= high){
80            int mid = low + (high - low)/2;
81            
82            if(prefix[mid] == target) return mid;
83            else if(prefix[mid] > target){
84                high = mid -1;
85            }else{
86                ans = mid;
87                low = mid + 1;
88            }
89        }
90
91        return ans;
92    }
93}