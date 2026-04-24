// Last updated: 4/24/2026, 10:31:15 AM
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int max = 0;

        for(int i = 0; i<n-1; i++){
            if(colors[i] != colors[n-1]){
                max = n-i-1;
                break;
            }
        }

        for(int i = n-1; i>=1; i--){
            if(colors[0] != colors[i]){
                max = Math.max(max, i);
                break;
            }
        }

        return max;
    }
}