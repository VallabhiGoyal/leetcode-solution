// Last updated: 4/24/2026, 10:33:24 AM
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        int i = 0;
        while(i<n){
            int correct = nums[i] - 1;
            if(nums[i]!=nums[correct]){
                swap(nums, i, correct);
            }else{
                i++;
            }
        }

        for(int  j= 0; j<n; j++) {
            if(nums[j] != j+1){
                return new int[]{nums[j], j+1};
            }
        }

        return new int[]{-1,-1};
    }

    static void swap(int[] arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}