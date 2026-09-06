// Last updated: 9/6/2026, 8:38:00 AM
1class Solution {
2    public int countGoodRotations(int[] nums) {
3        int n = nums.length;
4
5        int j = n/2;
6        long leftSum = 0;
7        long rightSum = 0;
8        for(int i = 0; i<j; i++){
9            leftSum += nums[i];
10            rightSum += nums[j+i];
11        }
12
13        int count = 0;
14        for(int i = 0; i < n; i++){
15            if(leftSum > rightSum) count++;
16            leftSum += nums[(i+j) % n] - nums[i];
17            rightSum += nums[i] - nums[(i+j) % n];
18        }
19
20        return count;
21    }
22}