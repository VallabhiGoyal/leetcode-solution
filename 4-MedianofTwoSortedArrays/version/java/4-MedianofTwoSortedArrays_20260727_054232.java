// Last updated: 7/27/2026, 5:42:32 AM
1import java.util.Arrays;
2class Solution {
3    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
4        int y = nums1.length + nums2.length;
5        int[] arr = new int[y];
6        
7        for(int i=0; i<nums1.length; i++){
8            arr[i] = nums1[i];
9        }
10        int x = nums1.length;
11        for(int i=0;i<nums2.length; i++){
12            arr[x+i] = nums2[i];
13        }
14        Arrays.sort(arr);
15        if(arr.length%2==0){
16            double z = (double)(arr[(arr.length-1)/2] + arr[(arr.length/2)])/2;
17            return z;
18        }
19
20        return arr[arr.length/2];
21        
22    }
23}