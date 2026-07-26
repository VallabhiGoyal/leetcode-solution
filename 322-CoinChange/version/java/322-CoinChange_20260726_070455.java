// Last updated: 7/26/2026, 7:04:55 AM
1class Solution {
2    public static int[][] t;
3    public int coinChange(int[] coins, int amount) {
4        int n = coins.length;
5        if(amount == 0) return 0;
6
7        t = new int[n+1][amount+1];
8        int INF = (int)1e9;
9
10        for(int i = 1; i<n+1; i++){
11            t[i][0] = 0;
12        }
13
14        for(int j = 0; j<amount + 1; j++){
15            t[0][j] = INF;
16        }
17
18        for(int i = 1; i<n+1; i++){
19            for(int j = 1; j<amount +1; j++){
20                if(coins[i-1] <= j){
21                    if(t[i][j - coins[i-1]] != INF) {
22                        t[i][j] = Math.min(1 + t[i][j-coins[i-1]], t[i-1][j]);
23                    }
24                    else{
25                        t[i][j] = t[i-1][j];
26                    }
27                }else{
28                    t[i][j] = t[i-1][j];
29                }
30            }
31        }
32
33        if(t[n][amount] == INF) return -1;
34        return t[n][amount];
35    }
36}