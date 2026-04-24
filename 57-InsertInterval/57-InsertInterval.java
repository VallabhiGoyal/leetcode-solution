// Last updated: 4/24/2026, 10:36:39 AM
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        List<int[]> list = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        int i = 0;
        for(i = 0; i<n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(end < newStart){
                list.add(intervals[i]);
            }else if(newEnd < start) break;
            else{
                newStart = Math.min(start, newStart);
                newEnd = Math.max(end, newEnd);
            }
        }

        list.add(new int[]{newStart, newEnd});

        for(int j = i; j<n; j++){
            list.add(intervals[j]);
        }

        int[][] ans = new int[list.size()][2];
        for(int j = 0; j<list.size(); j++){
            ans[j] = list.get(j);
        }

        return ans;
    }
}