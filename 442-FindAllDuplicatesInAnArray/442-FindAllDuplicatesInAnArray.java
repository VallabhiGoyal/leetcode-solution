// Last updated: 4/24/2026, 10:33:59 AM
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while(i<nums.length){
            int correct = nums[i] - 1;
            if(nums[i]>0 && nums[i] <=nums.length && nums[i] != nums[correct] ){
                swap(nums, i, correct);
            }else{
                i++;
            }
        }
        List<Integer> arr = new ArrayList<>();
        for(int j = 0; j<nums.length;j++){
            if(nums[j] != j+1){
                arr.add(nums[j]);
                
            }
        }
        return arr;
    }
    static void swap(int[]arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}