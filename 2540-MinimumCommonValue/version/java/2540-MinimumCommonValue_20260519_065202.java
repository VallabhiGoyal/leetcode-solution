// Last updated: 5/19/2026, 6:52:02 AM
1class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        int n = nums1.length;
4        int m = nums2.length;
5
6        int i = 0;
7        int j = 0;
8
9        while(i<n && j<m){
10            if(nums1[i] == nums2[j]) return nums1[i];
11            else if(nums1[i] > nums2[j]) j++;
12            else i++;
13        }    
14
15        return -1;
16    }
17}