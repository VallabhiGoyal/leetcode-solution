// Last updated: 4/24/2026, 10:32:04 AM
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int min = 0;
        
        for(int i = 1; i<points.length; i++){
            int x = Math.abs(points[i][0] - points[i-1][0]);
            int y = Math.abs(points[i][1] - points[i-1][1]);
            min += Math.max(x,y);
        }

        return min;
    }
}