// Last updated: 10/1/2026, 10:06:43 AM
1class Solution {
2    public int distinctAverages(int[] nums) {
3        int n = nums.length;
4
5        Arrays.sort(nums);
6
7        Set<Integer> set = new HashSet<>();
8        int i = 0; 
9        int j = n-1;
10
11        while(i<j){
12            set.add(nums[i++] + nums[j--]);
13        }        
14
15        return set.size();
16    }
17}