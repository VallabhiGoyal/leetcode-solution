// Last updated: 9/1/2026, 6:07:06 AM
1class Solution {
2    public int distributeCandies(int[] candyType) {
3        int n = candyType.length;
4
5        Set<Integer> set = new HashSet<>();
6        for(int i = 0; i<n; i++){
7            set.add(candyType[i]);
8        }
9
10        return Math.min(n/2, set.size());
11    }
12}