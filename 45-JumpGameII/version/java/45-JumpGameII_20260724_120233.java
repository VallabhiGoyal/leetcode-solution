// Last updated: 7/24/2026, 12:02:33 PM
1class Solution {
2    public int jump(int[] nums) {
3        int n = nums.length;
4
5        int jumps = 0;
6        int farthest = 0;
7        int currEnd = 0;
8
9        for(int i = 0; i<n-1; i++){
10            farthest = Math.max(farthest, nums[i] + i);
11            if(i == currEnd){
12                jumps++;
13                currEnd = farthest;
14            }
15        }
16
17        return jumps;
18    }
19}