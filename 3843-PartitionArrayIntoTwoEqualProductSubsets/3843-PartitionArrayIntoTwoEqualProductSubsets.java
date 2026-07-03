// Last updated: 7/3/2026, 11:36:31 AM
class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        long ans = 1;
        for(int num : nums){
            ans *= num;
        }

        if(ans != target*target) return false;
        
        return helper(nums, 1, 1, 0, target);
    }

    public boolean helper(int[] nums, long prodA, long prodB, int idx, long target){
        if(nums.length == idx){
            return prodA == prodB && prodA == target;
        }

        return helper(nums, nums[idx] * prodA, prodB, idx+1, target) || helper(nums, prodA, nums[idx] * prodB, idx + 1, target);
    }
}