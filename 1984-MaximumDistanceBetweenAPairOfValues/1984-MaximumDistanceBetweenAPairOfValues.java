// Last updated: 4/24/2026, 10:31:22 AM
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int max = 0;

        int i = 0;
        int j = 0;

        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                max = Math.max(max, j-i);
            }else i++;
            j++;
        }

        return max;
    }
}