// Last updated: 9/20/2026, 8:09:55 AM
1class Solution {
2    public int countIntersectingIntervals(int[][] intervals) {
3        int n = intervals.length;
4
5        Arrays.sort(intervals, (a, b) -> {
6            if(a[0] != b[0]) return a[0] - b[0];
7            return a[1] - b[1];
8        });
9
10        int count = 0;
11        for(int i = 0; i<n; i++){
12            for(int j = i+1; j<n; j++){
13                if(intervals[j][0] <= intervals[i][1]) count++;
14                else break;
15            }
16        }
17
18        return count;
19    }
20}