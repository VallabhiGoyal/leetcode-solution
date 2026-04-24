// Last updated: 4/24/2026, 10:32:17 AM
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m < n) return maxUncrossedLines(nums2, nums1);

        int[] t = new int[n+1];

        for(int i = 1; i<m+1; i++){
            int prev = 0;
            for(int j = 1; j<n+1; j++){

                int curr = t[j];

                if(nums1[i-1] == nums2[j-1]){
                    t[j] = prev + 1;
                }else{
                    t[j] = Math.max(t[j-1], curr);
                }

                prev = curr;
            }
        }

        return t[n];
    }
}