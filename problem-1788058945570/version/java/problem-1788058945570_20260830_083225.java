// Last updated: 8/30/2026, 8:32:25 AM
1class Solution {
2    public int sumDecoded(long[] nums) {
3        int n = nums.length;
4
5        long Mod = 1000000007;
6        
7        long sum = 0;
8
9        for(long num : nums){
10            int width = (int)(num % 10);
11            long d = num / 10;
12
13            String str = String.valueOf(d);
14            
15            String xSb = str.substring(0, width);
16            String ySb = str.substring(width, str.length());
17
18            long x = Long.parseLong(xSb) % Mod;
19            long y = Long.parseLong(ySb) % Mod;
20
21            long temp = power(x, y, Mod);
22
23            sum = (sum + temp) % Mod;
24        }
25
26        return (int)sum;
27    }
28
29    public long power(long x, long y, long Mod){
30        long ans = 1;
31
32        while(y > 0){
33            if((y & 1) == 1){
34                ans = (ans*x) % Mod;
35            }
36
37            x = (x*x)%Mod;
38            y >>= 1;
39        }
40
41        return ans;
42    }
43}