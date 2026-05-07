// Last updated: 5/7/2026, 6:37:03 AM
1class Solution {
2    public int[] maxValue(int[] nums) {
3        int n = nums.length;
4
5        int[] prefix = new int[n];
6        prefix[0] = nums[0];
7        for(int i = 1; i<n; i++){
8            prefix[i] = Math.max(prefix[i-1], nums[i]);
9        }
10
11        int[] suffix = new int[n];
12        suffix[n-1] = nums[n-1];
13        for(int i = n-2; i>=0; i--){
14            suffix[i] = Math.min(suffix[i+1], nums[i]);
15        }
16
17        int[] ans = new int[n];
18
19        int currMax = nums[0];
20        int start = 0;
21
22        for(int i = 0; i<n-1; i++){
23            currMax = Math.max(nums[i], currMax);
24
25            if(prefix[i] <= suffix[i+1]){
26
27                for(int k = start; k<=i; k++){
28                    ans[k] = currMax;
29                }
30
31                start = i + 1;
32                if(start < n){
33                    currMax = nums[start];
34                }
35            }
36        }
37
38        currMax = nums[start];
39        for(int i = start; i<n; i++){
40            currMax = Math.max(currMax, nums[i]);
41        }
42
43        for(int i = start; i<n; i++){
44            ans[i] = currMax;
45        }
46
47        return ans;
48    }
49}