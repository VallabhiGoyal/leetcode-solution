// Last updated: 4/24/2026, 10:36:24 AM
class Solution {
    public void sortColors(int[] nums) {
        int[] farr = new int[3];

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                farr[0]++;
            }else if(nums[i] == 1){
                farr[1]++;
            }else{
                farr[2]++;
            }
        }

        int i = 0; 
        int j = 0;
        while(i<nums.length ){
            if(farr[j]>0){
                nums[i] = j;
                farr[j]--;
                i++;
            }else{
                j++;
            }
            
        }
    }
}