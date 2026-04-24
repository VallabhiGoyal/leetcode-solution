// Last updated: 4/24/2026, 10:34:47 AM
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] answer = new int[n];
        int product = 1;
        int countZ = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] == 0){
                countZ++;
                continue;
            }
            product *= nums[i];
        }

        if(countZ>1){
            for(int i = 0; i<n; i++){
                answer[i] = 0;
            }
            return answer;
        }

        for(int i = 0; i<n; i++){
            if(countZ > 0){
                if(nums[i]!=0){
                    answer[i] = 0;
                    continue;
                }
            }
            if(nums[i] == 0){
                answer[i] = product;
                continue;
            }
            answer[i] = product/nums[i];
        }

        return answer;

    }
}