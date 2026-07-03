// Last updated: 7/3/2026, 11:34:42 AM
class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;

        int countZero = 0;

        for(int i = 0; i<n; i++){
            if(nums[i] == 0) countZero++;
        }

        if(countZero == n) return 0;

        int i = 0; 
        int j = n-1;
        int count = 0;

        while(j>=0 && nums[j] == 0) j--;

        while(i<j){
            if(nums[i] != 0){
                i++;
                continue;
            }

            while(i<j && nums[j] == 0) j--;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
            count++;
            
            while(i<j && nums[j] == 0) j--;            
        }

        return count;
    }
}