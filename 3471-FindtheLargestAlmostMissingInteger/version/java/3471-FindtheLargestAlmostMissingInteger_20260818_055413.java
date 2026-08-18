// Last updated: 8/18/2026, 5:54:13 AM
1class Solution {
2    public int largestInteger(int[] nums, int k) {
3        int n = nums.length;
4
5        if(n == k){
6            int max = nums[0];
7            for(int num : nums){
8                max = Math.max(num, max);
9            }
10
11            return max;
12        }
13        
14        int[] freq = new int[51];
15
16        int max = nums[0];
17        for(int num : nums){
18            freq[num]++;
19        }
20
21        if(k == 1){
22            for(int i = 50; i>0; i--){
23                if(freq[i] == 1) return i;
24            }
25            return -1;
26        }
27
28        if(freq[nums[0]] > 1 && freq[nums[n-1]] > 1) return -1;
29        if(freq[nums[0]] == 1 && freq[nums[n-1]] == 1) return Math.max(nums[0], nums[n-1]);
30
31        return freq[nums[0]] == 1 ? nums[0] : nums[n-1];
32    }
33}