// Last updated: 4/24/2026, 10:32:46 AM
class Solution {
    
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        int moves = 0;

        while(dp[moves][k] < n){
            moves++;
            for(int eggs = 1; eggs <= k; eggs++){
                dp[moves][eggs] = dp[moves-1][eggs-1] + dp[moves-1][eggs] + 1;
            }
        }

        return moves;
    }
}