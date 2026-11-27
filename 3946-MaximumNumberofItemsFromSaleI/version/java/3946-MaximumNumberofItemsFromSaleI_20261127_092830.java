// Last updated: 11/27/2026, 9:28:30 AM
1class Solution {
2    public int maximumSaleItems(int[][] items, int budget) {
3        int n = items.length;
4
5        int ans = 0;
6
7        int[] bonus = new int[n];
8
9        for(int i = 0; i<n; i++){
10            
11            int facti = items[i][0]; 
12            
13            for(int j = 0; j<n; j++){
14                
15                if(i == j) continue;
16                
17                int factj = items[j][0];
18
19                if(factj % facti == 0) bonus[i]++;
20            }
21        }
22        
23        int[][] dp = new int[n+1][budget+1];
24    
25        for(int i = 1; i <= n; i++){
26            int price = items[i-1][1];
27            
28            for(int j = 0; j <= budget; j++){
29                dp[i][j] = dp[i-1][j];
30
31                if(price <= j){
32                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-price] + 1 + bonus[i-1]);
33                }
34
35                if(price <= j){
36                    dp[i][j] = Math.max(dp[i][j], dp[i][j-price] + 1);
37                }
38            }
39        }
40
41        return dp[n][budget];
42    }
43}