// Last updated: 7/6/2026, 8:44:43 AM
1class Solution {
2    public int removeCoveredIntervals(int[][] intervals) {
3        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
4        int count = 0, maxEnd = 0;
5        for (int[] interval : intervals) {
6            if (interval[1] > maxEnd) {
7                count++;
8                maxEnd = interval[1];
9            }
10        }
11        return count;
12    }
13}