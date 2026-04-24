// Last updated: 4/24/2026, 10:35:17 AM
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[] hold = new int[k+1];
        int[] sold = new int[k+1];

        for(int i = 0; i<k+1; i++){
            hold[i] = Integer.MIN_VALUE;
        }

        for(int i = 0; i<n; i++){
            for(int j = k; j>=1; j--){
                hold[j] = Math.max(hold[j], sold[j-1]- prices[i]);
                sold[j] = Math.max(sold[j], prices[i] + hold[j]);
            }
        }

        return sold[k];
    }
}