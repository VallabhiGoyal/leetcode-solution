// Last updated: 4/24/2026, 10:29:47 AM
class Solution {
    public int minimumPrefixLength(int[] nums) {
        int count = 0; 
        int n = nums.length;
        if(n <=1) return 0;

        for(int i = 0; i<n-1; i++){
            if(nums[i] < nums[i+1]) continue;
            count = i + 1;
        }

        return count;
    }
}