// Last updated: 4/24/2026, 10:37:15 AM
import java.util.Arrays;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int y = nums1.length + nums2.length;
        int[] arr = new int[y];
        
        for(int i=0; i<nums1.length; i++){
            arr[i] = nums1[i];
        }
        int x = nums1.length;
        for(int i=0;i<nums2.length; i++){
            arr[x+i] = nums2[i];
        }
        Arrays.sort(arr);
        if(arr.length%2==0){
            double z = (double)(arr[(arr.length-1)/2] + arr[(arr.length/2)])/2;
            return z;
        }

        return arr[arr.length/2];
        
    }
}