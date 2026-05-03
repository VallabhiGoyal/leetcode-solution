// Last updated: 5/3/2026, 11:00:53 AM
1class Solution {
2    public int[] countOppositeParity(int[] nums) {
3        int n = nums.length;
4
5        int[] answer = new int[n];
6        answer[n-1] = 0;
7        for(int i = n-2; i>=0; i--){
8            if((nums[i] % 2 == 0 && nums[i+1] % 2 == 0) || (nums[i] % 2 != 0 && nums[i+1] % 2 != 0)){
9                answer[i] = answer[i+1];
10            }else answer[i] = n - i - 1 - answer[i+1];
11        }
12
13        return answer;
14    }
15}