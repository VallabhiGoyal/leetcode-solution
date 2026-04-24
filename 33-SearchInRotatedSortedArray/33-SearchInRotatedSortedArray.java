// Last updated: 4/24/2026, 10:36:56 AM
class Solution {
    
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1;
        int pivot = findPivot(arr);
        if(pivot  == -1){
            return binarySearch(arr, target, 0, arr.length -1);
        }
        if(arr[pivot] == target){
            return pivot;
        }
        if(target >= arr[start]){
            return binarySearch(arr, target, 0, pivot -1);
        }else{
            return binarySearch(arr, target, pivot + 1, end);
        }
    }
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            // case 1
            if(mid <end && arr[mid]>arr[mid+1]){
                return mid;
            }//case 2
            if(mid>start && arr[mid]<arr[mid-1]){
                return mid -1;
            }//case 3
            if(arr[mid]>=arr[start]){
                start = mid + 1;
            }else{ //case 4
                end = mid - 1;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<arr[mid]){
                end = mid -1;
            }else if(target> arr[mid]){
                start = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}