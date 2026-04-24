// Last updated: 4/24/2026, 10:31:30 AM
class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;

        int maxAlt = 0;
        int currAlt = 0;
        for(int i = 0; i<n; i++){
            currAlt += gain[i];
            if(currAlt > maxAlt) maxAlt = currAlt;
        }

        return maxAlt;
    }
}