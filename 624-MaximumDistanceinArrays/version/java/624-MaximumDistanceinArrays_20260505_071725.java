// Last updated: 5/5/2026, 7:17:25 AM
1class Solution {
2    public int maxDistance(List<List<Integer>> arrays) {
3        int n = arrays.size();
4
5        int min = arrays.get(0).get(0);
6        int max = arrays.get(0).get(arrays.get(0).size()-1);
7        
8        int d = Integer.MIN_VALUE;
9        for(int i = 1; i<n; i++){
10            int currMin = arrays.get(i).get(0);
11            int currMax = arrays.get(i).get(arrays.get(i).size()-1);
12            d = Math.max(d, Math.abs(currMax-min));
13            d = Math.max(d, Math.abs(max - currMin));
14            min = Math.min(min, currMin);
15            max = Math.max(max, currMax);
16        }
17
18        return d;
19    }
20}