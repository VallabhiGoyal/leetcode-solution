// Last updated: 4/26/2026, 9:55:12 AM
1class Solution {
2    public int compareBitonicSums(int[] nums) {
3        int n = nums.length;
4        if(n == 1) return -1;
5        
6        long leftSum = 0;
7        long rightSum = 0;
8
9        int i = 0;
10        while(i<n-1 && nums[i] < nums[i+1]){
11            leftSum += nums[i];
12            i++;
13        }
14        leftSum += nums[i];
15
16        for(int j = i; j<n; j++){
17            rightSum += nums[j];
18        }
19
20        if(leftSum > rightSum) return 0;
21        else if(leftSum < rightSum) return 1;
22        return -1; 
23    }
24}