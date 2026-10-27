// Last updated: 10/27/2026, 6:55:33 AM
1class Solution {
2    public int lastStoneWeight(int[] stones) {
3        int n = stones.length;
4
5        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
6
7        for(int stone : stones){
8            pq.add(stone);
9        }
10
11        while(pq.size() > 1){
12            int x = pq.poll();
13            int y = pq.poll();
14
15            if(x != y) pq.add(x - y);
16        }
17        if(pq.size() == 0) return 0;
18        return pq.poll();
19    }
20}