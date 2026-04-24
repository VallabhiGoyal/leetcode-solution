// Last updated: 4/24/2026, 10:31:31 AM
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int m = boxTypes.length;

        Arrays.sort(boxTypes, (a, b) -> a[1] - b[1]);
        int ans = 0;
        for(int i = m-1; i>=0; i--){
            if(truckSize <= boxTypes[i][0]){
                return ans += truckSize * boxTypes[i][1];
            }else{
                ans += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
                if(truckSize <= 0) return ans;
            }
        }
        return ans;
    }
}