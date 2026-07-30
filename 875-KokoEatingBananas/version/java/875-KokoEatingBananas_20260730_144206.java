// Last updated: 7/30/2026, 2:42:06 PM
1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        int n = piles.length;
4
5        int max = piles[0];
6        for(int i = 0; i<n; i++){
7            max = Math.max(max, piles[i]);
8        }
9
10        // ans btw [1, max]
11
12        return helper(piles, 1, max, h);
13    
14    }
15
16    public int helper(int[] piles, int min, int max, int h){
17        if(min > max) return min;
18
19        int n = piles.length;
20
21        int mid = min + (max - min)/2;
22
23        int ans = 0;
24        for(int i = 0; i  < n; i++){
25            ans += (piles[i] + mid - 1) / mid;
26            if(ans > h) break;
27        }
28
29        if(ans <= h){
30            return helper(piles, min, mid - 1, h);
31        }else{
32            return helper(piles, mid + 1, max, h);
33        }
34    }
35}