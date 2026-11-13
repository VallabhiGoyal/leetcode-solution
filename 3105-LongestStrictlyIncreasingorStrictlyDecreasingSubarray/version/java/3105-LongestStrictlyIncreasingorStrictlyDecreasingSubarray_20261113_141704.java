// Last updated: 11/13/2026, 2:17:04 PM
1class Solution {
2    public int longestMonotonicSubarray(int[] nums) {
3        int curI = 1;
4        int curD = 1;
5        int ans = 1;
6        for(int i = 1;i<nums.length;i++){
7            if(nums[i]> nums[i-1]){
8                curI++;
9                curD = 1;
10            }
11            else if(nums[i]< nums[i-1]){
12                curD++;
13                curI = 1;
14            }
15            else{
16                curI=1;
17                curD=1;
18            }
19            ans = Math.max(ans,Math.max(curI,curD));
20        }
21        return ans;
22    }
23}