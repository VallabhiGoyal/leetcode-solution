// Last updated: 4/24/2026, 10:32:48 AM
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int max = piles[0];
        int min = 1;
        for(int i = 0; i<n; i++){
            max = Math.max(max, piles[i]);
        }

        // ans btw [1, max]
        while(min <= max){
            int mid = min + (max-min)/2;
            int k = 0;
            for(int i = 0; i<n; i++){
                k += (piles[i] + mid - 1) / mid;
                if(k > h) break;
            }
            if(k <= h){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return min;
    }
}