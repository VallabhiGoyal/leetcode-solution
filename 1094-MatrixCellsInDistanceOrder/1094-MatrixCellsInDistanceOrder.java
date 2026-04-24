// Last updated: 4/24/2026, 10:32:18 AM
class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int total = rows*cols;

        int[][] temp = new int[total][3];
        int k = 0;

        for(int  i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                int dist = Math.abs(i - rCenter) + Math.abs(j - cCenter);
                temp[k][0] = i;
                temp[k][1] = j;
                temp[k++][2] = dist;
            }
        }
        Arrays.sort(temp, (a,b) -> a[2]-b[2]);

        int[][] answer = new int[total][2];
        for(int i = 0; i<total; i++){
            answer[i][0] = temp[i][0];
            answer[i][1] = temp[i][1];
        }

        return answer;
    }
}