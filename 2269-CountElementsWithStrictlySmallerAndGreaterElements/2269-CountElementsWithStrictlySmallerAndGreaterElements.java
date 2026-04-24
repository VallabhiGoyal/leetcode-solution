// Last updated: 4/24/2026, 10:31:07 AM
class Solution {
    public int countElements(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;
        Arrays.sort(nums);
        
        int i = 1;
        while(i<n && nums[i] == nums[0]) i++;
        int k = n-2;
        while(k>=0 && nums[k] == nums[n-1]) k--;
        return Math.max(0, k - i + 1);
    }
}