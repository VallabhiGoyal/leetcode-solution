// Last updated: 4/24/2026, 10:33:12 AM
class Solution {
    public int pivotIndex(int[] arr) {
        int n = arr.length;
        if(n==0) return -1;
        if(n==1) return 0;
        if(n == 2){
            if(arr[1] == 0) return 0;
            if(arr[0] == 0) return 1;
            return -1;
        }

        int totalSum = 0;
        for(int i = 0; i<n; i++){
            totalSum += arr[i];
        }

        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0; i<n; i++){
            rightSum = totalSum - leftSum - arr[i];
            if(leftSum == rightSum) return i;
            leftSum += arr[i];
        }

        return -1;
    }
}