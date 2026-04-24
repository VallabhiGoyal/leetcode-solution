// Last updated: 4/24/2026, 10:31:08 AM
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;

        long[] dp = new long[n];
        dp[n-1] = questions[n-1][0];

        for(int i = n-2; i>=0; i--){
            int points = questions[i][0];
            int brainpower = questions[i][1];
            long skip = dp[i+1];
            int next = i + brainpower + 1;
            long solve = points + (next < n ? dp[next] : 0);
            dp[i] = Math.max(skip, solve);
            
        }

        return dp[0];
    }
}