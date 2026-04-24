// Last updated: 4/24/2026, 10:35:44 AM
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int hold1 = -prices[0];
        int sold1 = 0;

        int hold2 = -prices[0];
        int sold2 = 0;

        for(int i = 1; i<n; i++){
            int prevHold1 = hold1;
            int prevSold1 = sold1;

            int prevHold2 = hold2;
            int prevSold2 = sold2;

            hold1 = Math.max(prevHold1, -prices[i]);
            sold1 = Math.max(prevSold1, prices[i] + prevHold1);

            hold2 = Math.max(prevHold2, prevSold1 - prices[i]);
            sold2 = Math.max(prevSold2, prices[i] + prevHold2);
        }

        return sold2;
    }
}