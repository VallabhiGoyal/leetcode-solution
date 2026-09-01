// Last updated: 9/1/2026, 6:05:58 AM
1class Solution {
2    public int distributeCandies(int[] candyType) {
3        int n = candyType.length;
4
5        Map<Integer, Integer> map = new HashMap<>();
6        for(int i = 0; i<n; i++){
7            map.merge(candyType[i], 1, Integer::sum);
8        }
9
10        return Math.min(n/2, map.size());
11    }
12}