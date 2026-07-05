// Last updated: 7/5/2026, 9:14:58 AM
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int i = 0;
4        while(i<nums.length){
5            int correct = nums[i] - 1 ;
6            
7            if(nums[i]>0 && nums[i]<=nums.length && nums[i] != nums[correct]){
8                swap(nums, i, correct);
9            }
10            else{
11                i++;
12            }
13        }
14        
15        for(int j = 0; j<nums.length;j++){
16            if(nums[j] != j+1){
17                return j+1;    
18            }
19        }
20        return nums.length+1;
21        
22    }
23    static void swap(int[]arr, int first, int last){
24        int temp = arr[first];
25        arr[first] = arr[last];
26        arr[last] = temp;
27    }
28}