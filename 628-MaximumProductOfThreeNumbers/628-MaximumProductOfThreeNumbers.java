// Last updated: 4/24/2026, 10:33:28 AM
class Solution {
    public int maximumProduct(int[] arr) {
        int n = arr.length;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int max =  Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){

            if(min1>arr[i]){
                min2 = min1;
                min1= arr[i];
            }else if(min2>arr[i]) min2 = arr[i];

            if(max<arr[i]){
                max2 = max1;
                max1 = max;
                max = arr[i];
            }else if(max1<arr[i]){
                max2 = max1;
                max1 = arr[i];
            }else if(max2<arr[i]){
                max2 = arr[i];
            }
        }

        return Math.max(min1*min2*max, max*max1*max2);

    }
}