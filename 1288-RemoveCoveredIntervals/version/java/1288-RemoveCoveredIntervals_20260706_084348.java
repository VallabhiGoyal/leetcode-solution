// Last updated: 7/6/2026, 8:43:48 AM
1class Solution {
2    public int removeCoveredIntervals(int[][] intervals) {
3        Arrays.sort(intervals, (a,b) -> {
4            if(a[0] != b[0]) return a[0] - b[0];
5            else return a[1] - b[1];
6        });
7
8        int n = intervals.length;
9        int count = 1;
10        int l = intervals[0][0];
11        int r = intervals[0][1];
12
13        for(int i = 1; i<n; i++){
14            if((l <= intervals[i][0] && intervals[i][1] <= r) || (l >= intervals[i][0] && intervals[i][1] >= r)){
15                l = Math.min(l, intervals[i][0]);
16                r = Math.max(r, intervals[i][1]);
17            }else{
18                count++;
19                l = intervals[i][0];
20                r = intervals[i][1];
21            }
22        }
23
24        return count;
25    }
26}