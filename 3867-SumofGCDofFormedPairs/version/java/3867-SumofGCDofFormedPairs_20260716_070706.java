// Last updated: 7/16/2026, 7:07:06 AM
1class Solution {
2    public long gcdSum(int[] nums) {
3        int n = nums.length;
4
5        int[] prefixGcd = new int[n];
6
7        int max = nums[0];
8        for(int i = 0; i<n; i++){
9            max = Math.max(max, nums[i]);
10            prefixGcd[i] = gcd(max, nums[i]);
11        }
12
13        Arrays.sort(prefixGcd);
14
15        long ans = 0;
16
17        int i = 0;
18        int j = n-1;
19
20        while(i<j){
21            ans += gcd(prefixGcd[i], prefixGcd[j]);
22            i++;
23            j--;
24        }
25
26        return ans;
27    }
28
29    public int gcd(int a , int b){
30        while(b != 0){
31            int temp = b;
32            b = a % b;
33            a = temp;
34        }
35        return a;
36    }
37}