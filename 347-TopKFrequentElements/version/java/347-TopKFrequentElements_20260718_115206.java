// Last updated: 7/18/2026, 11:52:06 AM
1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        Map<Integer, Integer> map = new HashMap<>();
4
5        int n = nums.length;
6        for(int num : nums){
7            map.put(num, map.getOrDefault(num, 0) + 1);
8        }
9
10        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
11        for(int key : map.keySet()){
12            pq.add(key);
13        }
14
15        int[] ans = new int[k];
16        int i = 0;
17        while(i < k && !pq.isEmpty()){
18            ans[i++] = pq.poll();
19        }
20
21        return ans;
22    }
23}