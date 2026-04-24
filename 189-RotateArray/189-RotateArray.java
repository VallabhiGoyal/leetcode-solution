// Last updated: 4/24/2026, 10:35:16 AM
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
            
            //reverse the first part of the arrray(k-> n)
            reverse(nums, 0, n-k-1);

            //REVERSE THE second PART OF THE ARRAyY (0->k-1)
            reverse(nums, n-k, n-1);

            //reverse the wole array
            reverse(nums, 0, n-1);
        
    }

    public void reverse(int[] arr, int start, int end){
        if(start <0 || end>=arr.length){
            return;
        }
        while(start<end && end>=0 && start<arr.length){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}