// Last updated: 4/24/2026, 10:32:50 AM
class Solution {
    public int binaryGap(int n) {
        int maxDiff = 0;
        int preIdx = -1;
        int next = 0;
        while(n>0){
            int bit = n & 1;
            if(bit == 1){
                if(preIdx != -1){
                    maxDiff = Math.max(maxDiff, next-preIdx);
                }
                preIdx = next;
            }
            next++;
            n = n>>1;
        }

        return maxDiff;
    }
}