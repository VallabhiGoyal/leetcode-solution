// Last updated: 4/24/2026, 10:31:58 AM
class Solution {
    public int minimumDistance(String word) {
        int n = word.length();

        int[][] dp = new int[n][26];

        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for(int j = 0; j<26; j++){
            dp[0][j] = 0;
        }

        for(int i  = 1; i<n; i++){
            int curr = word.charAt(i) - 'A';
            int prev = word.charAt(i-1) - 'A';

            for(int j = 0; j<26; j++){
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + dist(prev, curr));
                dp[i][prev] = Math.min(dp[i][prev], dp[i-1][j] + dist(j, curr));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int j = 0; j<26; j++){
            ans = Math.min(dp[n-1][j], ans);
        }

        return ans;
    }

    private int dist(int prev, int curr){
        int rowP = prev / 6;
        int colP = prev % 6;

        int rowC = curr / 6;
        int colC = curr % 6;

        return Math.abs(rowP - rowC) + Math.abs(colP - colC);
    }
}