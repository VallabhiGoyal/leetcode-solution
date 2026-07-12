// Last updated: 7/12/2026, 8:50:39 AM
1class Solution {
2    public int minimumCost(int[] nums, int k) {
3        int n = nums.length;
4
5        long MOD = 1000000007;
6        long temp = k;
7        long j = 1;
8        
9        for(int i = 0; i<n; i++){
10            if(temp < nums[i]){
11                long need = (nums[i] - temp + k - 1L)/k;
12                temp += need*k;
13                j = j+need;
14            }
15            temp -= nums[i];
16        }
17        j %= MOD;
18        return (int)((j*(j-1)/2)%MOD);
19    }
20}