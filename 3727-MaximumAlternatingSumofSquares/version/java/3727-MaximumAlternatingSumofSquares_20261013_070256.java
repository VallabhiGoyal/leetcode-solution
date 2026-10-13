// Last updated: 10/13/2026, 7:02:56 AM
1class Solution {
2    public long maxAlternatingSum(int[] nums) {
3        long odd_sum = 0;
4        long even_sum = 0;
5
6        int[] arr = new int[nums.length];
7        for(int i = 0; i<nums.length; i++){
8            arr[i] = Math.abs(nums[i]);
9        }
10        
11        Arrays.sort(arr);
12
13        int mid = arr.length/2;
14        for(int i = 0; i<mid; i++){
15            odd_sum += arr[i]*arr[i];
16        }
17
18        for(int i = mid; i<arr.length; i++){
19            even_sum += arr[i]*arr[i];
20        }
21
22        return even_sum - odd_sum;
23    }
24}