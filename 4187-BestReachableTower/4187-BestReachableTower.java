// Last updated: 4/24/2026, 10:29:49 AM
class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int maxQ = Integer.MIN_VALUE;
        int bestX = 0;
        int bestY = 0;
        for(int i = 0; i<towers.length; i++){
            int x = Math.abs(towers[i][0] - center[0]);
            int y = Math.abs(towers[i][1] - center[1]);

            int reach = x+y;
            if(reach > radius) continue;
            if(towers[i][2]>maxQ){
                maxQ = towers[i][2];
                bestX = towers[i][0];
                bestY = towers[i][1];
            }else if(towers[i][2] == maxQ){
                if (towers[i][0] < bestX || (towers[i][0] == bestX && towers[i][1] < bestY)) {
                    bestX = towers[i][0];
                    bestY = towers[i][1];
                }
            }
        }

        if(maxQ == Integer.MIN_VALUE) return new int[]{-1,-1};

        return new int[]{bestX, bestY};
        
    }
}