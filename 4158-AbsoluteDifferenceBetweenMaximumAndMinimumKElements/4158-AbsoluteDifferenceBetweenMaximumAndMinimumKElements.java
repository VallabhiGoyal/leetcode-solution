// Last updated: 4/24/2026, 10:29:57 AM
class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 0;
        int max = 0;
        int i = 0;
        while(k>0 && i<nums.length){
            min += nums[i];
            max += nums[nums.length-i-1];
            i++;
            k--;
        }

        return Math.abs(max-min);

    }
}