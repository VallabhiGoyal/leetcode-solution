// Last updated: 4/24/2026, 10:32:23 AM
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int maxWeight = 0;
        int max = weights[0];
        for(int i = 0; i<n; i++){
            maxWeight += weights[i];
            max = Math.max(max, weights[i]);
        }

        int start = max;
        int end = maxWeight;

        while(start <= end){
            int mid = start + (end - start)/2;
            int currDays = 1;
            int currWeight = 0;
            for(int i = 0; i<n; i++){
                currWeight += weights[i];
                if(currWeight > mid){
                    currDays++;
                    currWeight = weights[i];
                }
                if(currDays > days) break;
            }
            if(currDays > days){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }

        return start;
    }
}