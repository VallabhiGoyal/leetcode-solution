// Last updated: 4/24/2026, 10:31:33 AM
class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        int i = 0; 
        int j = n-1;
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum == k){
                count++;
                j--;
                i++;
            }else if(sum<k) i++;
            else j--;
        }
        
        return count;
    }
}