// Last updated: 10/2/2026, 9:54:07 AM
1class Solution {
2    public void wiggleSort(int[] nums) {
3       int n = nums.length-1;
4
5       int[] temp=Arrays.copyOf(nums,nums.length);
6
7       Arrays.sort(temp);
8        
9        for(int i = 1; i<nums.length; i+=2){
10            nums[i] = temp[n--];
11        }
12            
13        for(int i = 0; i<nums.length; i+=2){
14            nums[i] = temp[n--];
15        }
16    }
17}
18       