// Last updated: 5/3/2026, 11:56:42 AM
1class Solution {
2    public int[] minCost(int[] nums, int[][] queries) {
3        int m = nums.length;
4        
5        //closest
6        int[] closest = new int[m];
7        for(int i = 0; i<m; i++){
8            if(i == 0) closest[i] = 1;
9            else if(i == m-1) closest[i] = m-2;
10            else{
11                int left = Math.abs(nums[i-1] - nums[i]);
12                int right = Math.abs(nums[i] - nums[i+1]);
13
14                if(left <= right) closest[i] = i-1;
15                else closest[i] = i + 1;
16            }
17        }
18
19        //forward path sum
20        long[] forward = new long[m];
21        for(int i = 0; i<m-1; i++){
22            if(closest[i] == i + 1){
23                forward[i+1] = forward[i] + 1;
24            }else{
25                forward[i+1] = forward[i] + nums[i+1] - nums[i];
26            }
27        }
28
29        //backward path sum
30        long[] back = new long[m];
31        for(int i = m-1; i>0; i--){
32            if(closest[i] == i-1){
33                back[i-1] = back[i] + 1;
34            }else{
35                back[i-1] = back[i] + nums[i] - nums[i-1];
36            }
37        }
38
39        //ans 
40        int n = queries.length;
41        int[] ans = new int[n];
42        
43        for(int i = 0; i<n; i++){
44            int x = queries[i][0];
45            int y = queries[i][1];
46
47            if(x < y){
48                ans[i] = (int)(forward[y] - forward[x]);
49            }else{
50                ans[i] = (int)(back[y] - back[x]);
51            }
52        }
53
54        return ans;
55    }
56}