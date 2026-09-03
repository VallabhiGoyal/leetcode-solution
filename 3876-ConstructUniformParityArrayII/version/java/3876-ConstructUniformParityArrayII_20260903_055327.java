// Last updated: 9/3/2026, 5:53:27 AM
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int n = nums1.length;
4        if(n==1) return true;
5        
6        int minOdd = Integer.MAX_VALUE;
7        int minEven = Integer.MAX_VALUE;
8
9        for (int num : nums1) {
10            if (num % 2 == 0) {
11                minEven = Math.min(minEven, num);
12            }else {
13                minOdd = Math.min(minOdd, num);
14            }
15        }
16
17        if(minEven == Integer.MAX_VALUE || minOdd == Integer.MAX_VALUE) return true;
18        return minEven > minOdd;
19    }
20}