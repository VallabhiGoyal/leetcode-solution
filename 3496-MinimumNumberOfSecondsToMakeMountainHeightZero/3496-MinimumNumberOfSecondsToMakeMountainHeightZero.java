// Last updated: 4/24/2026, 10:30:33 AM
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;

        // fastest worker
        int min = workerTimes[0];
        for(int i = 0; i<n; i++){
            min = Math.min(min, workerTimes[i]);
        }

        long minTime = (long)min * mountainHeight*(mountainHeight + 1)/2;

        long start = 1;
        long end = minTime;

        while(start <= end){
            long mid = start + (end - start)/2;
            long height = 0;
            for(int i = 0; i<n; i++){
                long k = (2L*mid)/workerTimes[i];
                long x = (long)Math.sqrt(1 + 4 * k);
                x = (x - 1) / 2;
                height += x;
                if(height  >= mountainHeight) break;
            }
            if(height >= mountainHeight){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }
}