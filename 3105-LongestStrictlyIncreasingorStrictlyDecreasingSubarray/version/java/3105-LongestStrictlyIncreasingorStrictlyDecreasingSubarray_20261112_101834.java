// Last updated: 11/12/2026, 10:18:34 AM
1class Solution {
2    public int longestMonotonicSubarray(int[] nums) {
3        int n = nums.length;
4
5        int[] inc = new int[n];
6        int[] desc = new int[n];
7
8        Arrays.fill(inc, 1);
9        Arrays.fill(desc, 1);
10
11        for(int i = 1; i<n; i++){
12            if(nums[i] > nums[i-1]){
13                inc[i] = inc[i-1] + 1;
14            }
15
16            if(nums[i] < nums[i-1]){
17                desc[i] = desc[i-1] + 1;
18            }
19        }
20
21        int max = 1;
22        for(int i = 0; i<n; i++){
23            max = Math.max(max, Math.max(inc[i], desc[i]));
24        }
25
26        return max;
27    }
28}