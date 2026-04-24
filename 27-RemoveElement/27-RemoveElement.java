// Last updated: 4/24/2026, 10:36:58 AM
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        int count =0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=val){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;        
    }
}