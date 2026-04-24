// Last updated: 4/24/2026, 10:36:32 AM
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length-1;
        int i = n;
        digits[n] += 1;
        if(digits[i]>=10){
            while(i>0){
                if(digits[i] >=10){
                    digits[i-1] +=1;
                }
                digits[i] = digits[i]%10;
                i--;
            }
            if(digits[0]>=10){
                digits[0] = digits[0]%10;
                int nums[] = new int[n+2];
                nums[0] = 1;
                for(int j = 1; j<nums.length; j++){
                    nums[j] = digits[j-1];
                }

                return nums;
            }
        }
        return digits;
    }
}