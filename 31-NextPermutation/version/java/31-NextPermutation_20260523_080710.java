// Last updated: 5/23/2026, 8:07:10 AM
1class Solution {
2    public void nextPermutation(int[] nums) {
3        int n = nums.length;
4
5        int idx = -1;
6
7        for(int i = n-2; i>=0; i--){
8            if(nums[i] < nums[i+1]){
9                idx = i;
10                break;
11            }
12        }
13
14        if(idx == -1){
15            Arrays.sort(nums);
16        }else{
17            int currIdx = idx;
18            int currMin = Integer.MAX_VALUE;
19            for(int i = idx+1; i<n; i++){
20                if(nums[i] > nums[idx] && currMin > nums[i]){
21                    currMin = nums[i];
22                    currIdx = i;
23                }
24            }
25            
26            int temp = nums[idx];
27            nums[idx] = nums[currIdx];
28            nums[currIdx] = temp;
29
30            Arrays.sort(nums, idx+1, n);
31        } 
32    }
33}