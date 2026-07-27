// Last updated: 7/27/2026, 12:30:00 PM
1class NumArray {
2    
3    int[] prefix;
4    int[] temp;
5    public NumArray(int[] nums) {
6        int n = nums.length;
7
8        temp = new int[n];
9        for(int i = 0; i<n; i++){
10            temp[i] = nums[i];
11        }
12
13        prefix = new int[n];
14        prefix[0] = nums[0];
15
16        for(int i = 1; i<n; i++){
17            prefix[i] = prefix[i-1] + nums[i];
18        }
19    }
20    
21    public int sumRange(int left, int right) {
22        return prefix[right] - prefix[left] + temp[left];
23    }
24}
25
26/**
27 * Your NumArray object will be instantiated and called as such:
28 * NumArray obj = new NumArray(nums);
29 * int param_1 = obj.sumRange(left,right);
30 */