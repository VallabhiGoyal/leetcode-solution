// Last updated: 4/24/2026, 10:34:01 AM
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int count = 0;
        int j = 0;
        for(int i = 1; i<n; i++){
            if(intervals[i][0] >= intervals[j][1]){
                j = i;
            }else count++;
        }

        return count;
    }
}