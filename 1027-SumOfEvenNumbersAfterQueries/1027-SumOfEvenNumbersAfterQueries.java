// Last updated: 4/24/2026, 10:32:32 AM
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] answer  = new int[queries.length];

        int sumEven = 0;
        for(int i = 0; i<n; i++){
            if(nums[i]%2==0){
                sumEven+=nums[i];
            }
        }

        for(int i = 0; i<queries.length; i++){
            int index = queries[i][1];
            int val = queries[i][0];
            if((nums[index] & 1) == 0){
                sumEven -= nums[index];
            }
            nums[index] += val;
            if((nums[index] & 1) ==0){
                sumEven += nums[index];
            }
            answer[i] = sumEven;
        }

        return answer;
    }
}