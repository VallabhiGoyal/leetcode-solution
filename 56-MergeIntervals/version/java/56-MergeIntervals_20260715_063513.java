// Last updated: 7/15/2026, 6:35:13 AM
1class Solution {
2    public int[][] merge(int[][] intervals) {
3        Arrays.sort(intervals, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
4
5        List<int[]> list = new ArrayList<>();
6        
7        int start = intervals[0][0];
8        int end = intervals[0][1];
9
10        int n = intervals.length;
11
12        for(int i = 1; i<n; i++){
13            int a = intervals[i][0];
14            int b = intervals[i][1];
15
16            if(start <= a && end >= a){
17                end = Math.max(end, b);
18            }else{
19                list.add(new int[] {start, end});
20                start = a;
21                end = b;
22            }
23        }
24
25        list.add(new int[]{start, end});
26
27        return list.toArray(new int[list.size()][]);
28    }
29}