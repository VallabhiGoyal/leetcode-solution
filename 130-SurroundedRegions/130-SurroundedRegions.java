// Last updated: 4/24/2026, 10:35:38 AM
class Solution {
    public void solve(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        if(rows <=2 || cols <= 2) return;

        Queue<int[]> q = new ArrayDeque<>();

        //changing to # the safe ones
        for(int i = 0; i<rows; i++){
            if(board[i][0] == 'O'){
                board[i][0] = '#';
                q.add(new int[]{i,0});
            }
            if(board[i][cols-1] == 'O'){
                board[i][cols-1] = '#';
                q.add(new int[]{i,cols-1});
            }
        }
        for(int i = 0; i<cols; i++){
            if(board[0][i] == 'O'){
                board[0][i] = '#';
                q.add(new int[]{0,i});
            }
            if(board[rows-1][i] == 'O'){
                board[rows-1][i] = '#';
                q.add(new int[]{rows-1,i});
            }
        }

        //bfs
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];

            if(currR>0 && board[currR-1][currC] == 'O'){
                q.add(new int[] {currR-1, currC});
                board[currR-1][currC] = '#';
            }

            if(currR<rows-1 && board[currR+1][currC] == 'O'){
                q.add(new int[] {currR+1, currC});
                board[currR+1][currC] = '#';
            }

            if(currC>0 && board[currR][currC-1] == 'O'){
                q.add(new int[] {currR, currC-1});
                board[currR][currC-1] = '#';
            }

            if(currC<cols-1 && board[currR][currC+1] == 'O'){
                q.add(new int[] {currR, currC+1});
                board[currR][currC+1] = '#';
            }
            
        }

        //changing the unsafe one
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                //rechange
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}