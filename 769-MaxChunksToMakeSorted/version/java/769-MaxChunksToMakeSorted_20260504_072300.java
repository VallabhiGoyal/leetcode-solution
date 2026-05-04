// Last updated: 5/4/2026, 7:23:00 AM
1class Solution {
2    public int maxChunksToSorted(int[] arr) {
3        int n = arr.length;
4
5        int ans = 0;
6        int i = 0;
7        int maxSoFar = arr[0];
8        while(i<n){
9            maxSoFar = Math.max(maxSoFar, arr[i]);
10            if(maxSoFar == i) ans++;
11            i++;
12        }
13
14        return ans;
15    }
16}