// Last updated: 4/24/2026, 10:34:19 AM
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<nums1.length; i++){
            set.add(nums1[i]);
        } 

        Set<Integer> result = new HashSet<>();
        for(int i = 0; i<nums2.length; i++){
            if(set.contains(nums2[i])) result.add(nums2[i]);
        }

        int size = result.size();
        int[] ans = new int[size];
        int i = 0;
        for(int n : result){
            ans[i++] = n;
        }

        return ans;
    }
}