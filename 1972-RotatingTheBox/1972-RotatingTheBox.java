// Last updated: 7/3/2026, 11:37:34 AM
class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        char[][] rotated = new char[n][m];

        for(int i = 0; i<m; i++){
            int empty = n-1;
            for(int j = n-1; j>=0; j--){
                char curr = boxGrid[i][j];
                if(curr == '*'){
                    empty = j-1;
                }else if(curr == '#'){
                    boxGrid[i][j] = '.';
                    boxGrid[i][empty] = '#';
                    empty--;
                }
            }
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                rotated[j][m-1-i] = boxGrid[i][j];
            }
        }

        return rotated;
    }
}