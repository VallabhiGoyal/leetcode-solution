// Last updated: 11/15/2026, 9:53:29 PM
1class Solution {
2    public int numOfSubarrays(int[] arr) {
3        int mod = 1_000_000_007;
4
5        long even = 1;
6        long odd = 0;
7        long sum = 0;
8        long ans = 0;
9
10        for(int num : arr) {
11            sum += num;
12
13            if(sum % 2 == 0) {
14                ans = (ans + odd) % mod;
15                even++;
16            } else {
17                ans = (ans + even) % mod;
18                odd++;
19            }
20        }
21
22        return (int) ans;
23    }
24}
25