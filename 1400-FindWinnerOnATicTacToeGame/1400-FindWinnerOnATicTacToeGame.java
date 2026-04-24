// Last updated: 4/24/2026, 10:32:01 AM
class Solution {
    public String tictactoe(int[][] moves) {
        int totalMoves = moves.length;
        String[][] grid = new String[3][3];

        for(int i = 0; i<totalMoves; i++){
            int row = moves[i][0];
            int col = moves[i][1];
            if(i%2==0) grid[row][col] = "X";
            else grid[row][col] = "0";
        }

        //row check
        for(int i = 0; i<3; i++){
            if(grid[i][0] != null && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]){
                if(grid[i][0] == "X") return "A";
                else return "B";
            }
        }

        //col check
        for(int i = 0; i<3; i++){
            if(grid[0][i] != null && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]){
                if(grid[0][i] == "X") return "A";
                else return "B";
            }
        }

        //diagonal check
        if(grid[0][0] != null && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]){
            if(grid[0][0] == "X") return "A";
            else return "B";
        }

        if(grid[0][2] != null && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]){
            if(grid[0][2] == "X") return "A";
            else return "B";
        }

        if(totalMoves<9) return "Pending";
        return "Draw";
    }
}