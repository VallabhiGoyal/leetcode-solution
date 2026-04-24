// Last updated: 4/24/2026, 10:31:34 AM
class Solution {
    public int maximumWealth(int[][] accounts) {
        int a = accounts.length;
        int b = accounts[0].length;

        int maxWealth = 0;
        for(int i = 0; i<a; i++){
            int wealth = 0;
            for(int j = 0; j<b; j++){
                wealth += accounts[i][j];
            }

            maxWealth = Math.max(maxWealth, wealth);
        }

        return maxWealth;
    }
}