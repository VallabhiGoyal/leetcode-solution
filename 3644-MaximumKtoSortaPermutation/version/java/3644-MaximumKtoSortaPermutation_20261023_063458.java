// Last updated: 10/23/2026, 6:34:58 AM
1class Solution {
2    public int sortPermutation(int[] nums) {
3        int n = nums.length;
4
5        int k = -1;
6
7        for(int i = 0; i<n; i++){
8            if(nums[i] == i) continue;
9
10            if(k == -1){
11                k = nums[i];
12            }else{
13                k &= nums[i];
14            }
15        }
16
17        if(k == -1) return 0;
18        return k;
19    }
20}