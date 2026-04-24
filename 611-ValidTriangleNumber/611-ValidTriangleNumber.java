// Last updated: 4/24/2026, 10:33:31 AM
class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;

        Arrays.sort(nums);
        
        int count = 0;
        for(int i = 2; i<n; i++){
            int j = 0;
            int k = i-1;
            while(j<k){
                if(nums[j] + nums[k] > nums[i]){
                    count += k-j;
                    k--;
                }
                else j++;
            }
        }

        return count;
    }
}