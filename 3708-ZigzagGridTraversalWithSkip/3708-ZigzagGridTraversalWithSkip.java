// Last updated: 4/24/2026, 10:30:27 AM
import java.util.ArrayList;
class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        for(int i =0; i<grid.length;i++){
            if(i%2==0){
                for(int j = 0; j<grid[0].length; j=j+2){
                    list.add(grid[i][j]);
                }
            }else{
                int j = grid[0].length-1;
                
                for(j=grid[0].length -1 ; j>=0; j--){
                    if(j%2!=0){
                        list.add(grid[i][j]);
                    }    
                }
                
            }
        }
        return list;
    }
}