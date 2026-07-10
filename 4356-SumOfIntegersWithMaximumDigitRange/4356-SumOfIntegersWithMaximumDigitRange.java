// Last updated: 7/10/2026, 6:54:51 PM
class Solution {
    public int maxDigitRange(int[] nums) {
        int n = nums.length;

        int[] freq = new int[10];
        
        for(int i = 0; i<n; i++){
            int curr = nums[i];
            int maxDigit = 0;
            int minDigit = 9;
            while(curr > 0){
                int remain = curr % 10;
                maxDigit = Math.max(remain, maxDigit);
                minDigit = Math.min(remain, minDigit);
                curr/=10;
            }

            int range = maxDigit - minDigit;
            freq[range] += nums[i];
        }

        for(int i = 9; i>=0; i--){
            if(freq[i] != 0){
                return freq[i];
            }
        }

        return 0;
    }

    
}