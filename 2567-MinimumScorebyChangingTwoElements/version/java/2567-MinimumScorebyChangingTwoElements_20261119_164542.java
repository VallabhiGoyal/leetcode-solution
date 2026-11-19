// Last updated: 11/19/2026, 4:45:42 PM
1class Solution {
2    public int minimizeSum(int[] nums) {
3        if(nums.length==3){
4            return 0;
5        }
6        
7        Arrays.sort(nums);
8        int a=nums[nums.length-1]-nums[2];
9        
10        int b=nums[nums.length-3]-nums[0];
11        
12        int c=nums[nums.length-2]-nums[1];
13        
14        return Math.min(a,Math.min(b,c));
15        
16        
17    }
18}