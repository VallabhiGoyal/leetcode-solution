// Last updated: 4/24/2026, 10:33:19 AM
class Solution {
    public int findNumberOfLIS(int[] nums) {
    
        int n = nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];

        for(int i = 0; i<n; i++){
            dp[i] = 1;
            count[i] = 1;
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(nums[i] > nums[j]){
                    if(dp[i] < 1 + dp[j]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if(dp[i] == 1 + dp[j]) count[i] += count[j];
                }
            }
        }

        int max = 0;
        int j = 0;
        for(int i = 0; i<n; i++){
            if(max < dp[i]){
                max = dp[i];
                j = i;
            }
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            if(dp[i] == max) ans += count[i];
        }

        return ans;
    }
}