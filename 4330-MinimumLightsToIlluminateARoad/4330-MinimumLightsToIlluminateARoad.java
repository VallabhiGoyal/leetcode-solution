// Last updated: 7/3/2026, 11:34:34 AM
class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;

        int[] dp = new int[n+1];
        for(int i = 0; i<n; i++){
            int v = lights[i];

            if(v == 0) continue;
            
            int max = Math.max(0, i - v);
            int min = Math.min(i+v, n-1);

            dp[max]++;
            if(min + 1 < n) dp[min+1]--;
        }
        
        boolean[] bulbs = new boolean[n];
        int currBulbs = 0;
        for(int i = 0; i<n; i++){
            currBulbs += dp[i];
            if(currBulbs > 0) bulbs[i] = true;
        }

        int ans = 0;
        for(int i = 1; i<n; i++){
            if(bulbs[i-1]) continue;
            
            ans++;
            bulbs[i] = true;
            if(i>0) bulbs[i-1] = true;
            if(i<n-1) bulbs[i+1] = true;
        }

        if(!bulbs[n-1]) ans++;

        return ans;
    }
}