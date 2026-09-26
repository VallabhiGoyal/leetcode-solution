// Last updated: 9/26/2026, 8:05:49 PM
1class Solution {
2    public boolean canTransform(int[] source, int[] target) {
3        int n = source.length;
4
5        long sum1 = 0L;
6        long sum2 = 0L;
7
8        for(int i = 0; i<n; i++){
9            sum1 += source[i];
10            sum2 += target[i];
11        }
12
13        return sum1 == sum2;
14    }
15}