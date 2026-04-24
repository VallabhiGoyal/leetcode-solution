// Last updated: 4/24/2026, 10:36:53 AM
class Solution {
    public boolean isValidSudoku(char[][] board) {
        

        //row and col check
        for(int i = 0; i<9; i++){
            int[] row = new int[10];
            int[] col = new int[10];
            for(int j = 0; j<9; j++){
                int curr1 = board[i][j] - '0';
                int curr2 = board[j][i] - '0';
                if(board[i][j] != '.') row[curr1]++;
                if(board[j][i] != '.') col[curr2]++;
            }

            for(int k = 1; k<10; k++){
                if(row[k] > 1 || col[k] > 1) return false;
            }
        }

        //grid check
        return gridCheck(board, 0, 0) && gridCheck(board, 0, 3) && gridCheck(board, 0, 6) && gridCheck(board, 3,0) && gridCheck(board, 3, 3) && gridCheck(board, 3, 6) && gridCheck(board, 6, 0) && gridCheck(board, 6, 3) && gridCheck(board, 6, 6); 
    }

    private boolean gridCheck(char[][] board, int i, int j){
        int[] subBox = new int[10];
        for(int row = i; row<i+3; row++){
            for(int col = j; col<j+3; col++){
                int curr = board[row][col] - '0';
                if(board[row][col] != '.') subBox[curr]++;
            }
        }

        for(int row = 1; row < 10; row++){
            if(subBox[row]>1) return false;
        }

        return true;
    }
}