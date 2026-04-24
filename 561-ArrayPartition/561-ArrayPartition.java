// Last updated: 4/24/2026, 10:33:38 AM
import java.util.Arrays;
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        for(int i = 0; i<=nums.length-2; i +=2){
            maxSum += nums[i];
        }
        return maxSum;
    }
}