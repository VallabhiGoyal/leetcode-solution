// Last updated: 5/28/2026, 7:17:29 AM
1class Solution {
2    public int threeSumClosest(int[] nums, int target) {
3        int n = nums.length;
4
5        Arrays.sort(nums);
6
7        int ans = Integer.MAX_VALUE;
8        int diff = Integer.MAX_VALUE;
9
10        for(int i = 0; i<n; i++){
11            
12            int k = n-1;
13            int j = i+1;
14
15            while(j<k){
16                int sum = nums[i] + nums[j] + nums[k];
17                if(sum < target){
18                    if(diff > target - sum){
19                        diff = target - sum;
20                        ans = sum;
21                    }
22                    
23                    j++;
24
25                }else if(sum > target){
26                    if(diff > sum - target){
27                        diff = Math.abs(target - sum);
28                        ans = sum;
29                    }
30
31                    k--;
32                }else{
33                    return target;
34                }
35            }
36        }
37
38        return ans;
39    }
40}