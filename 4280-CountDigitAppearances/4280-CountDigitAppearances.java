// Last updated: 4/24/2026, 10:29:16 AM
class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int n = nums.length;

        int count = 0;
        for(int i = 0; i<n; i++){
            int curr = nums[i];
            while(curr> 0){
                int remain = curr%10;
                if(remain == digit) count++;
                curr /= 10;
            }
        }

        return count;
    }
}