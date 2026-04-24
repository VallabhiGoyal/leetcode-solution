// Last updated: 4/24/2026, 10:34:29 AM
class Solution {
    public static int[][] t;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0;

        t = new int[n+1][amount+1];
        int INF = (int)1e9;

        for(int i = 1; i<n+1; i++){
            t[i][0] = 0;
        }

        for(int j = 0; j<amount + 1; j++){
            t[0][j] = INF;
        }

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<amount +1; j++){
                if(coins[i-1] <= j){
                    if(t[i][j - coins[i-1]] != INF) {
                        t[i][j] = Math.min(1 + t[i][j-coins[i-1]], t[i-1][j]);
                    }
                    else{
                        t[i][j] = t[i-1][j];
                    }
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        if(t[n][amount] == INF) return -1;
        return t[n][amount];
    }
}