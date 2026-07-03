// Last updated: 7/3/2026, 11:34:52 AM
class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;

        int[] answer = new int[n];
        answer[n-1] = 0;
        for(int i = n-2; i>=0; i--){
            if((nums[i] % 2 == 0 && nums[i+1] % 2 == 0) || (nums[i] % 2 != 0 && nums[i+1] % 2 != 0)){
                answer[i] = answer[i+1];
            }else answer[i] = n - i - 1 - answer[i+1];
        }

        return answer;
    }
}