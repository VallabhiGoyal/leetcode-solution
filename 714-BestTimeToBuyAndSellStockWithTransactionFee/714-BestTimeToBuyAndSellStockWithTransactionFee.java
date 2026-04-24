// Last updated: 4/24/2026, 10:33:13 AM
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n == 1) return 0;

        int hold = -prices[0];
        int sold = 0;

        for(int i = 1; i<n; i++){
            int prevSold = sold;
            int prevHold = hold;

            hold = Math.max(prevHold, prevSold-prices[i]); 
            sold = Math.max(prevSold, prevHold + prices[i] - fee);
        }
        
        return sold;
    }
}