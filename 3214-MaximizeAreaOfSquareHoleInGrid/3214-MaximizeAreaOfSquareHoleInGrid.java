// Last updated: 4/24/2026, 10:30:41 AM
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int countH = 0;
        for(int i = 0; i< hBars.length-1; i++){
            int j = i;
            int count = 0;
            while(j<hBars.length-1 && hBars[j] == hBars[j+1] - 1){
                count++;
                j++;
            }
            i = j;
            countH = Math.max(count, countH);
        }

        int countV = 0;
        for(int i = 0; i< vBars.length-1; i++){
            int j = i;
            int count = 0;
            while(j<vBars.length-1 && vBars[j] == vBars[j+1] - 1){
                count++;
                j++;
            }
            i = j;
            countV = Math.max(count, countV);
        }

        countH = (hBars.length > 0) ? countH + 2 : 1;
        countV = (vBars.length > 0) ? countV + 2 : 1;

        int maxSide = Math.min(countH, countV);
        return maxSide * maxSide;
    }
}