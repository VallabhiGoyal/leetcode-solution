// Last updated: 8/25/2026, 4:51:03 AM
1class Solution {
2    public int stoneGameVIII(int[] stones) {
3        int n = stones.length;
4
5        long aliceScore = 0;
6        long bobScore = 0;
7
8        long[] prefix = new long[n];
9        prefix[0] = stones[0];
10
11        for(int i = 1; i<n; i++){
12            prefix[i] = prefix[i-1] + stones[i];
13        }
14
15        long maxDiff = prefix[n-1];
16        for(int i = n-2; i>0; i--){
17            maxDiff = Math.max(prefix[i] - maxDiff, maxDiff);
18        }
19
20        return (int)maxDiff;
21    }
22}