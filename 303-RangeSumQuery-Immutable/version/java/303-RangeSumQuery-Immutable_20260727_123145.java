// Last updated: 7/27/2026, 12:31:45 PM
1class NumArray {
2    
3    int[] prefix;
4    public NumArray(int[] nums) {
5        int n = nums.length;
6
7        prefix = new int[n];
8        prefix[0] = nums[0];
9
10        for(int i = 1; i<n; i++){
11            prefix[i] = prefix[i-1] + nums[i];
12        }
13    }
14    
15    public int sumRange(int left, int right) {
16        if(left == 0) return prefix[right];
17        return prefix[right] - prefix[left-1];
18    }
19}
20
21/**
22 * Your NumArray object will be instantiated and called as such:
23 * NumArray obj = new NumArray(nums);
24 * int param_1 = obj.sumRange(left,right);
25 */