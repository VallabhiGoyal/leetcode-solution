// Last updated: 7/3/2026, 11:37:17 AM
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int[] ans = new int[n];

        int j = 0;

        for(int num : nums){
            if(num < pivot) ans[j++] = num;
        }

        for(int num : nums){
            if(num == pivot) ans[j++] = pivot;
        }

        for(int num : nums){
            if(num > pivot) ans[j++] = num;
        }

        return ans;
    }
}