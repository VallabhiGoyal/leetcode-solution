// Last updated: 7/3/2026, 11:36:30 AM
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int ans = 0;

        int[] bonus = new int[n];

        for(int i = 0; i<n; i++){
            
            int facti = items[i][0]; 
            
            for(int j = 0; j<n; j++){
                
                if(i == j) continue;
                
                int factj = items[j][0];

                if(factj % facti == 0) bonus[i]++;
            }
        }
        
        int[][] dp = new int[n+1][budget+1];
    
        for(int i = 1; i <= n; i++){
            int price = items[i-1][1];
            
            for(int j = 0; j <= budget; j++){
                dp[i][j] = dp[i-1][j];

                if(price <= j){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-price] + 1 + bonus[i-1]);
                }

                if(price <= j){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-price] + 1);
                }
            }
        }

        return dp[n][budget];
    }
}