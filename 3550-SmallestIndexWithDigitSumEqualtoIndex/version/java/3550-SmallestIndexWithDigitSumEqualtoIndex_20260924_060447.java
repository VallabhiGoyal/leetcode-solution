// Last updated: 9/24/2026, 6:04:47 AM
1class Solution {
2    public int smallestIndex(int[] nums) {
3        int n = nums.length;
4
5        for(int i = 0; i < n; i++){
6            int sum = digitSum(nums[i]);
7
8            if(sum == i) return i;
9        }
10
11        return -1;
12    }
13
14    public int digitSum(int n){
15        if(n == 0) return 0;
16        
17        int temp = n;
18        int sum = 0;
19        while(temp != 0){
20            int remain = temp % 10;
21            sum += remain;
22            temp /= 10;
23        }
24
25        return sum;
26    }
27}