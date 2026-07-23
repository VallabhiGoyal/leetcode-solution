// Last updated: 7/23/2026, 12:53:23 PM
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length;
4    
5        if(n == 1 || n == 2) return n; 
6
7        int bits = 32 - Integer.numberOfLeadingZeros(n);
8        
9        return 1 << bits;
10    }
11}