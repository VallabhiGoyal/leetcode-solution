// Last updated: 5/14/2026, 6:43:38 AM
1class Solution {
2    public boolean isGood(int[] nums) {
3        int n = nums.length;
4
5        int[] freq = new int[n];
6
7        for(int i = 0; i<n; i++){
8            if(nums[i] < n) freq[nums[i]]++;
9            else return false;
10
11            if(nums[i] != n-1 && freq[nums[i]]>1) return false; 
12        }
13
14        for(int i = 1; i<n; i++){
15            if(i == n-1 && freq[n-1] != 2) return false;
16            else if(i != n-1 && freq[i] != 1) return false; 
17        }
18
19        return true;
20    }
21}