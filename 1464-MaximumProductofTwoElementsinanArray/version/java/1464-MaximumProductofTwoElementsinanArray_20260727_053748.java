// Last updated: 7/27/2026, 5:37:48 AM
1class Solution {
2    public int maxProduct(int[] nums) {
3        int n = nums.length;
4
5        int max1 = nums[0];
6        int max2 = Integer.MIN_VALUE;
7
8        for(int i = 1; i < n; i++){
9            if(max1 <= nums[i]){
10                max2 = max1;
11                max1 = nums[i];
12            }else if(max2 < nums[i]){
13                max2 = nums[i];
14            }
15        }
16
17        return (max1 - 1)*(max2 - 1);
18    }
19}