// Last updated: 9/20/2026, 8:14:12 AM
1class Solution {
2    public long countIntersectingIntervals(int[][] intervals) {
3        int n = intervals.length;
4
5        Arrays.sort(intervals, (a, b) -> {
6            if(a[0] != b[0]) return a[0] - b[0];
7            return a[1] - b[1];
8        });
9
10        PriorityQueue<Integer> pq = new PriorityQueue<>();
11
12        long count = 0;
13        
14        for(int i = 0; i<n; i++){
15            int s = intervals[i][0];
16            int e = intervals[i][1];
17
18            while(!pq.isEmpty() && pq.peek() < s){
19                pq.poll();
20            }
21
22            count += pq.size();
23
24            pq.offer(e);
25        }
26
27        return count;
28    }
29}