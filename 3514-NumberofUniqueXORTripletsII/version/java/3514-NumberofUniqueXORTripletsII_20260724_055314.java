// Last updated: 7/24/2026, 5:53:14 AM
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length;
4
5        boolean[] dp1 = new boolean[2048];
6
7        for(int num : nums){
8            dp1[num] = true;
9        }
10
11        boolean[] dp2 = new boolean[2048];
12
13        for(int i = 0; i < 2048; i++){
14            if(dp1[i]){
15                for(int num : nums){
16                    dp2[i ^ num] = true;
17                }
18            }
19        }
20
21        boolean[] dp3 = new boolean[2048];
22
23        for(int i = 0; i < 2048; i++){
24            if(dp2[i]){
25                for(int num : nums){
26                    dp3[i ^ num] = true;
27                }
28            }
29        }
30
31        int count = 0;
32
33        for(boolean temp : dp3){
34            if(temp) count++;
35        }
36
37        return count;
38    }
39}