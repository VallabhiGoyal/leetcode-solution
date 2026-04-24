// Last updated: 4/24/2026, 10:32:26 AM
class Solution {
    public int numRookCaptures(char[][] board) {
        int a = board.length;
        int b = board[0].length;

        boolean found = false;
        int row = 0;
        int col = 0;
        for(int i = 0; i<a; i++){
            for(int j = 0; j<b; j++){
                if(board[i][j] == 'R'){
                    row = i;
                    col = j;
                    found = true;
                    break;
                }
            }
            if(found) break;
        }

        int count = 0;
        //row check
        for(int j = col-1; j>=0; j--){
            if(board[row][j] == 'p'){
                count++;
                break;
            }

            if(board[row][j] == 'B') break;
        }

        for(int j = col+1; j<b; j++){
            if(board[row][j] == 'p'){
                count++;
                break;
            }

            if(board[row][j] == 'B') break;
        }

        //col check
        for(int i = row-1; i>=0; i--){
            if(board[i][col] == 'p'){
                count++;
                break;
            }

            if(board[i][col] == 'B') break;
        }

        for(int i = row+1; i<a; i++){
            if(board[i][col] == 'p'){
                count++;
                break;
            }

            if(board[i][col] == 'B') break;
        }


        return count;
    }
}