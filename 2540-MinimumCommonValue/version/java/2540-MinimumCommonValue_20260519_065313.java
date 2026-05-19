// Last updated: 5/19/2026, 6:53:13 AM
1class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        int n = nums1.length;
4        int m = nums2.length;
5
6        if(nums1[n-1] < nums2[0] || nums1[0] > nums2[m-1]) return -1;
7        
8        int i = 0;
9        int j = 0;
10
11        while(i<n && j<m){
12            if(nums1[i] == nums2[j]) return nums1[i];
13            else if(nums1[i] > nums2[j]) j++;
14            else i++;
15        }    
16
17        return -1;
18    }
19}