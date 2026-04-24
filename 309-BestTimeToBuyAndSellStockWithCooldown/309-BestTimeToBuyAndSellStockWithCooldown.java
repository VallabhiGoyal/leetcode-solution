// Last updated: 4/24/2026, 10:34:32 AM
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;

        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for(int i = 1; i<n; i++){
            int prevRest = rest;
            int prevSold = sold;
            int prevHold = hold;
            rest = Math.max(prevRest, prevSold);
            sold = prevHold + prices[i];
            hold = Math.max(prevHold, prevRest - prices[i]);           
        }

        return Math.max(sold, rest);
    }
}