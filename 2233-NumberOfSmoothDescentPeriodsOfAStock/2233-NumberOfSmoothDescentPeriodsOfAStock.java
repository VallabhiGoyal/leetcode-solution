// Last updated: 4/24/2026, 10:31:13 AM
class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        long count = 1;    
        long streak = 1;

        for (int i = 1; i < n; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                streak++;
            } else {
                streak = 1;
            }
            count += streak;
        }

        return count;
    }
}
