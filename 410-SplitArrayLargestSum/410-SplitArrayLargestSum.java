// Last updated: 4/24/2026, 10:34:06 AM
class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        
        int max = 0;
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        int start = max;
        int end = sum;

        while(start <= end){
            int mid = start + (end - start)/2;
            int arr = 1;
            int currSum = 0;
            for(int i = 0; i<n; i++){
                if(currSum + nums[i] > mid){
                    arr++;
                    currSum = 0;
                }
                currSum += nums[i];
                if(arr > k) break;
            }
            if(arr <= k){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }
}