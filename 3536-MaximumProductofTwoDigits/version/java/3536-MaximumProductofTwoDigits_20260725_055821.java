// Last updated: 7/25/2026, 5:58:21 AM
1class Solution {
2    public int maxProduct(int n) {
3        int max1 = Integer.MIN_VALUE;
4        int max2 = Integer.MIN_VALUE;
5
6        int temp = n;
7
8        while(temp > 0){
9            int remain = temp % 10;
10
11            if(max1 <= remain){
12                if(max1 == Integer.MIN_VALUE){
13                    max1 = remain;
14                }else{
15                    max2 = max1;
16                    max1 = remain;
17                }
18            }else if(max2 <= remain){
19                max2 = remain;
20            }
21
22            temp /= 10;
23        }
24
25        return max1*max2;
26    }
27
28}