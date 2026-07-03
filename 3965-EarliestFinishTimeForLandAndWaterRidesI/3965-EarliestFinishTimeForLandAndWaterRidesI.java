// Last updated: 7/3/2026, 11:36:21 AM
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        
        int n = landStartTime.length;
        int m = waterStartTime.length;

        int minTime = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            int currTime = landStartTime[i] + landDuration[i];
            for(int j = 0; j<m; j++){
                int temp  = Math.max(currTime, waterStartTime[j]) + waterDuration[j];
                
                minTime = Math.min(minTime, temp);
            }
        }

        for(int i = 0; i<m; i++){
            int currTime = waterStartTime[i] + waterDuration[i];
            for(int j = 0; j<n; j++){
                int temp = Math.max(currTime, landStartTime[j]) + landDuration[j];

                minTime = Math.min(minTime, temp);
            }            
        }


        return minTime;
    }
}