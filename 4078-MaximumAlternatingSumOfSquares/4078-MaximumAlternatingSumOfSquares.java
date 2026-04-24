// Last updated: 4/24/2026, 10:30:11 AM
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long odd_sum = 0;
        long even_sum = 0;

        int[] arr = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            arr[i] = Math.abs(nums[i]);
        }
        
        Arrays.sort(arr);

        int mid = arr.length/2;
        for(int i = 0; i<mid; i++){
            odd_sum += arr[i]*arr[i];
        }

        for(int i = mid; i<arr.length; i++){
            even_sum += arr[i]*arr[i];
        }

        return even_sum - odd_sum;
    }
}