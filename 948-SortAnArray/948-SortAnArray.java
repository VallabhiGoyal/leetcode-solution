// Last updated: 4/24/2026, 10:32:42 AM
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for (int i = n/2 - 1; i >= 0; i--) {
            downHeap(nums, i, n);
        }

        for (int end = n - 1; end > 0; end--) {
            swap(nums, 0, end);      
            downHeap(nums, 0, end); 
        }

        return nums;
    }

    private void swap(int arr[], int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    private void downHeap(int[] arr, int i, int heapSize){
        int largest = i;

        while(i < heapSize/2){
            int left = 2*i + 1;
            int right = 2*i + 2;

            if(left<heapSize && arr[left]>arr[largest]){
                largest = left;
            }

            if(right<heapSize && arr[right]>arr[largest]){
                largest = right;
            }

            if(largest == i) break;

            swap(arr, i, largest);

            i = largest;
        }
    }
}