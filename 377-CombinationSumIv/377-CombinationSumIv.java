// Last updated: 4/24/2026, 10:34:15 AM
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;

        int[] t = new int[target + 1];
        t[0] = 1;

        for(int i = 1; i<target+1; i++){
            for(int j = 1; j<n + 1; j++){
                if(nums[j-1] <= i){
                    t[i] += t[i-nums[j-1]];
                }
            }
        }

        return t[target];
    }
}