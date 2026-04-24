// Last updated: 4/24/2026, 10:36:14 AM
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int write = m+n-1;

        while(p1>=0 && p2>=0){
            if(nums1[p1]>nums2[p2]){
                nums1[write] = nums1[p1];
                p1--;
            }else{
                nums1[write] = nums2[p2];
                p2--;
            }
            write--;
        }
        
        while(p2>=0){
            nums1[write] = nums2[p2];
            p2--;
            write--;
        }
    }
}