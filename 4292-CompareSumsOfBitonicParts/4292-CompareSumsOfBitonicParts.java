// Last updated: 7/3/2026, 11:34:54 AM
class Solution {
    public int compareBitonicSums(int[] nums) {
        int n = nums.length;
        if(n == 1) return -1;
        
        long leftSum = 0;
        long rightSum = 0;

        int i = 0;
        while(i<n-1 && nums[i] < nums[i+1]){
            leftSum += nums[i];
            i++;
        }
        leftSum += nums[i];

        for(int j = i; j<n; j++){
            rightSum += nums[j];
        }

        if(leftSum > rightSum) return 0;
        else if(leftSum < rightSum) return 1;
        return -1; 
    }
}