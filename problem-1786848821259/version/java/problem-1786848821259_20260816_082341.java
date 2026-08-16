// Last updated: 8/16/2026, 8:23:41 AM
1class Solution {
2    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
3        int n = lights.length;
4        int m = arrivalTime.length;
5
6        int maxLight = lights[0];
7        for(int i = 1; i<n; i++){
8            maxLight = Math.max(maxLight, lights[i]);
9        }
10
11        int wt = 0;
12
13        for(int i = 0; i<m; i++){
14            int r = arrivalTime[i] % period;
15
16            if(r >= maxLight){
17                wt = Math.max(wt, period - r);
18            }
19        }
20
21        return wt;
22    }
23}