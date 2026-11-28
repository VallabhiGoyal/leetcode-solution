// Last updated: 11/28/2026, 9:45:42 AM
1class Solution {
2    public int maximumSaleItems(int[][] items, int budget) {
3        int n = items.length;
4        int minPrice = Integer.MAX_VALUE;
5
6        int[] freq = new int[n + 1];
7        int[] freeCount = new int[n + 1];
8
9        for (int i = 0; i < n; i++) {
10            freq[items[i][0]]++;
11            minPrice = Math.min(minPrice, items[i][1]);
12        }
13
14        for (int x = 1; x <= n; x++) {
15            for (int j = x; j <= n; j += x) {
16                freeCount[x] += freq[j];
17            }
18            freeCount[x]--; 
19        }
20
21        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));
22
23        int ans = 0;
24
25        for (int i = 0; i < n; i++) {
26            int factor = items[i][0];
27            int price = items[i][1];
28
29            if (price >= 2L * minPrice || price > budget)
30                break;
31
32            int count = Math.min(freeCount[factor], budget / price);
33
34            ans += count * 2;
35            budget -= count * price;
36        }
37
38        ans += budget / minPrice;
39        return ans;
40    }
41}