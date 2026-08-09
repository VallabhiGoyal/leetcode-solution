// Last updated: 8/9/2026, 8:04:41 AM
1class Solution {
2    public double minPrice(int[] prices, int[] discounts) {
3        Arrays.sort(prices);
4        Arrays.sort(discounts);
5
6        double ans = 0;
7
8        int n = prices.length;
9        int m = discounts.length;
10
11        int i = n-1;
12        int j = m-1;
13        while(i >= 0 && j >= 0){
14            ans += ((double)prices[i] * (double)(100 - discounts[j])/100);
15            i--;
16            j--;
17        }
18
19        while(i >= 0){
20            ans += prices[i];
21            i--;
22        }
23
24        return ans;
25    }
26}