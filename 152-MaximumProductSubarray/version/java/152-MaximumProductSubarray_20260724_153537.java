// Last updated: 7/24/2026, 3:35:37 PM
1class Solution {
2    public int maxProduct(int[] nums) {
3        int n = nums.length;
4
5        int max = nums[0];
6        int min = nums[0];
7        int ans = nums[0];
8
9        for(int i = 1; i < n; i++){
10            int curr = nums[i];
11
12            int prevMax = max;
13            int prevMin = min;
14
15            max = Math.max(curr, Math.max(curr * prevMax, curr * prevMin));
16
17            min = Math.min(curr, Math.min(curr * prevMax, curr * prevMin));
18
19            ans = Math.max(ans, max);
20        }
21
22        return ans;
23    }
24}