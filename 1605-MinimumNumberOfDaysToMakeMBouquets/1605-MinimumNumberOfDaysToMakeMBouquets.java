// Last updated: 4/24/2026, 10:31:42 AM
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        long total = (long)m * k;
        if(n<total) return -1;

        int min = bloomDay[0];
        int max = bloomDay[0];
        for(int i = 0; i<n; i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        int start = min;
        int end = max;
        while(start <= end){
            int mid = start + (end - start)/2;
            int bouquet = 0;
            int flower = 0;
            for(int i = 0; i<n; i++){
                if(bloomDay[i] <= mid){
                    flower++;
                    if(flower == k){
                        bouquet++;
                        flower = 0;
                    }
                }
                else{
                    flower = 0;
                }
                 
                if(bouquet >= m) break;
            }
            if(bouquet >= m){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return (int)start;
    }
}