// Last updated: 4/24/2026, 10:31:27 AM
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;

        int max = nums[0];
        for(int i = 1; i<n; i++){
            max = Math.max(max, nums[i]);
        }


        int start = 1;
        int end = max;
        while(start <= end){
            int mid = start + (end - start)/2;
            long totalOperations = 0;
            for(int i = 0; i<n; i++){
                totalOperations += (nums[i] - 1)/mid;
                if(totalOperations > maxOperations) break;
            }
            if(totalOperations <= maxOperations){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }
}