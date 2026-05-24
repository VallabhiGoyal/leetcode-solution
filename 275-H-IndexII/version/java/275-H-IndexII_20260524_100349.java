// Last updated: 5/24/2026, 10:03:49 AM
1class Solution {
2    public int hIndex(int[] citations) {
3        int n = citations.length;
4
5        int low = 0;
6        int high = n-1;
7
8        while(low < high){
9            int mid = low + (high - low)/2;
10
11            if(citations[mid] >= n - mid){
12                high = mid;
13            }else{
14                low = mid + 1;
15            }
16        }
17
18        if(citations[low] == 0) return 0;
19        return n-low;
20    }
21}