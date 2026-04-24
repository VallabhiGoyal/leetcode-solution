// Last updated: 4/24/2026, 10:35:02 AM
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length-k];
    }
}