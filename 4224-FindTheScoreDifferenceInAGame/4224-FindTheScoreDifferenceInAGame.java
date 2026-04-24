// Last updated: 4/24/2026, 10:29:40 AM
class Solution {
    public int scoreDifference(int[] nums) {
        int n = nums.length;

        int score1 = 0;
        int score2 = 0;
        boolean active1 = true;
        
        int  i = 0; 
        while(i<n){
            if((nums[i] & 1) == 1){
                active1 = !active1;
            }

            if(i%6==5){
                active1 = !active1;
            }

            if(active1) score1+=nums[i];
            else score2+=nums[i];
            i++;
        }

        return score1 - score2;
    }
}