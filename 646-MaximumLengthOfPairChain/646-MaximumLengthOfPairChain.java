// Last updated: 4/24/2026, 10:33:23 AM
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;

        Arrays.sort(pairs, (a,b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        int[] dp = new int[n];
        for(int i = 0; i<n; i++){
            dp[i] = 1;
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = dp[0];
        for(int i = 0; i<n; i++){
            if(max < dp[i]) max = dp[i];
        }

        return max;
    }
}