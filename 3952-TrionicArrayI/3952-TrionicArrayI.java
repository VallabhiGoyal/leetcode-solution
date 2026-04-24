// Last updated: 4/24/2026, 10:30:24 AM
class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(n<4) return false;
        
        int i = 0;
        int start = 0;
        while(i<n-1 && nums[i]<nums[i+1]) i++;
        if(i==start) return false;

        start=i;
        while(i<n-1 && nums[i]>nums[i+1]) i++;
        if(i==start) return false;

        start=i;
        while(i<n-1 && nums[i]<nums[i+1]) i++;
        if(i==start) return false;

        return i == n-1;
    }
}