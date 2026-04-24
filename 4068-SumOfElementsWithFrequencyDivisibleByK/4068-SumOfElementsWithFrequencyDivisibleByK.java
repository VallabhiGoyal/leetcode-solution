// Last updated: 4/24/2026, 10:30:12 AM
class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        
        int n = nums.length;
        int sum = 0;
        if(k==1){
            for(int i = 0; i<n; i++){
                sum+=nums[i];
            }
            return sum;
        }
        
        
        boolean[] arr = new boolean[nums.length];

        
        for(int i = 0; i<n-1; i++){
            
            if(arr[i])  continue;    
            
            int count = 1;

            for(int j = i+1; j<n; j++){
                
                if(!arr[j] && nums[i]==nums[j]){
                    arr[j] = true;
                    count++;
                }
                
            }

            if(count%k==0){
                sum += nums[i]*count;
            }
            
        }

        return sum;
    }
}