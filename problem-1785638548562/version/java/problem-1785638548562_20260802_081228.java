// Last updated: 8/2/2026, 8:12:28 AM
1class Solution {
2    public long maxPairStrength(int[] nums) {
3        int n = nums.length;
4
5        long ans = 0;
6        for(int i = 0; i<n; i++){
7            for(int j = i+1; j<n; j++){
8                int temp = gcd(nums[i], nums[j]);
9                long sq = temp * temp;
10                
11                if(ans < ((long)nums[i] * (long)nums[j])/sq){
12                    ans = ((long)nums[i] * (long)nums[j])/sq;
13                }
14            }
15        }
16
17        return ans;
18    }
19
20    public int gcd(int a, int b){
21        while(b != 0){
22            int temp = b;
23            b = a % b;
24            a = temp;
25        }
26
27        return a;
28    }
29}