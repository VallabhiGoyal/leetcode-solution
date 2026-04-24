// Last updated: 4/24/2026, 10:36:51 AM
class Solution {
    public void solveSudoku(char[][] board){
        solve(board);
    }
    private boolean solve(char[][] board) {
        int n = board.length;
        int row =-1;
        int col = -1;
        boolean emptyleft = false;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == '.'){
                    row = i;
                    col = j;
                    emptyleft = true;
                    break;
                }
            }
            if(emptyleft){
                break;
            }
        }
        if(emptyleft == false){
            return true;
        }

        for(char number = '1'; number<='9'; number++){
            if(isSafe(board, row, col, number)){
                board[row][col] = number;
                if(solve(board)){
                    return true;
                }
                board[row][col] = '.';    
            }
        }
        return false;
    }
    
    private boolean isSafe(char[][] board, int row, int col, char num){
        //check the rows
        for(int i = 0; i< board.length; i++){
            //check if the number is in the row and col
            if(board[row][i] == num || board[i][col] == num){
                return false;
            }
        }

        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;
        
        for(int r = rowStart; r < rowStart + sqrt; r++){
            for(int c = colStart; c < colStart + sqrt; c++){
                if(board[r][c]==num){
                    return false;
                }
            }
        }
        return true;
    }
}