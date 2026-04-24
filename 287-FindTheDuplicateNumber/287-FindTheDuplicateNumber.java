// Last updated: 4/24/2026, 10:34:35 AM
class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i<nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            }else{
                i++;
            }
        }
        for(int j = 0; j<nums.length;j++){
            if(nums[j] != j+1){
                return nums[j];
            }
        }
        return -1;
    }
    static void swap(int[]arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}