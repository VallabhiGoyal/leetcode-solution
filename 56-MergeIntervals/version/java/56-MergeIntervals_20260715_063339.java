// Last updated: 7/15/2026, 6:33:39 AM
1class Solution {
2    public int[][] merge(int[][] intervals) {
3        Arrays.sort(intervals, (a,b) -> {
4            if(a != b) return a[0] - b[0];
5            else return a[1] - b[1];
6        });
7
8        List<int[]> list = new ArrayList<>();
9        
10        int start = intervals[0][0];
11        int end = intervals[0][1];
12
13        int n = intervals.length;
14
15        for(int i = 0; i<n; i++){
16            int a = intervals[i][0];
17            int b = intervals[i][1];
18
19            if(start <= a && end >= a){
20                end = Math.max(end, b);
21            }else{
22                list.add(new int[] {start, end});
23                start = a;
24                end = b;
25            }
26        }
27
28        list.add(new int[]{start, end});
29
30        return list.toArray(new int[list.size()][]);
31    }
32}