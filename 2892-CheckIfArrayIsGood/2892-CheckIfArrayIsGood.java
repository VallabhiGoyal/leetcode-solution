// Last updated: 7/3/2026, 11:36:53 AM
class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;

        int[] freq = new int[n];

        for(int i = 0; i<n; i++){
            if(nums[i] < n) freq[nums[i]]++;
            else return false;

            if(nums[i] != n-1 && freq[nums[i]]>1) return false; 
        }

        for(int i = 1; i<n; i++){
            if(i == n-1 && freq[n-1] != 2) return false;
            else if(i != n-1 && freq[i] != 1) return false; 
        }

        return true;
    }
}