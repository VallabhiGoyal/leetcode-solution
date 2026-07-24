// Last updated: 7/24/2026, 12:03:09 PM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int minPrice = Integer.MAX_VALUE;
4        int maxProfit = 0;
5
6        for (int price : prices) {
7            if (price < minPrice) {
8                minPrice = price;
9            } else {
10                maxProfit = Math.max(maxProfit, price - minPrice);
11            }
12        }
13
14        return maxProfit;
15    }
16}
17